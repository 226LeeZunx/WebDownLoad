/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package murach.bussiness;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Set;
import murach.entity.Lobby;
import murach.entity.Product;
import murach.entity.User;
import murach.entity.UserPool;

/**
 *
 * @author dung2
 */
@WebServlet(name = "DangKiServlet",urlPatterns = {"/DangKi"})
public class DangKiServLet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String productcode=request.getParameter("productcode");
        HttpSession session=request.getSession();
        Lobby initLobby=(Lobby)getServletContext().getAttribute("initLobby");
        String url="/index.jsp" ;
        if(action==null){
            action = "default";
        }
        Product choosingProduct = null;
        if(productcode != null) {
          choosingProduct = initLobby.getProductById(productcode);
        }
        switch(action){
            case "check":
                session.setAttribute("productcode", productcode);
                String history="";
                Cookie[] cookies =request.getCookies();
                if(cookies!=null){
                    for(Cookie c : cookies){
                        if(c.getName().equals("viewHistory")){
                            history=c.getValue();
                            break;
                        }
                    }
                }
                if (!history.contains(productcode)) {
                   history = history.isEmpty() ? productcode : history + "-" + productcode;
                }
                Cookie historyCookie = new Cookie("viewHistory", history);
                historyCookie.setMaxAge(60 * 30); 
                historyCookie.setPath("/"); 
                response.addCookie(historyCookie);
                
                if (session.getAttribute("user")!=null){
                    url="/Download.jsp";
                    session.setAttribute("choosingProduct", choosingProduct);
                    
                }else{
                   url = "/register.jsp";
                }
                response.sendRedirect(request.getContextPath()+url);
                break;
            default:
                request.getRequestDispatcher("/index.jsp").forward(request, response); 
                break;
        }

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        UserPool UserDB = (UserPool)getServletContext().getAttribute("UserDB");
        Lobby initLobby=(Lobby)getServletContext().getAttribute("initLobby");

        String action = request.getParameter("action");
        HttpSession session= request.getSession();
        Product choosingProduct= initLobby.getProductById((String)session.getAttribute("productcode"));
        String url = "/index.jsp";
        
        if ("addAcc".equals(action)) {
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("Email");       
            User user= new User(firstName,lastName,email);
            session.setAttribute("user",user);

            synchronized (UserDB){
            if(UserDB.authenticate(email)==null){
                UserDB.addUser(firstName,lastName,email);
                session.setAttribute("choosingProduct",choosingProduct);
                url = "/Download.jsp";
                
            }else{
                session.setAttribute("Error","Email is exist please enter another");
                url ="/register.jsp";   
            }
            }
        }else if("backToLobby".equals(action)){
            url="/index.jsp";
        }
        
        response.sendRedirect(request.getContextPath()+url);

    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
