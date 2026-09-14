/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package murach.bussiness;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import murach.entity.Lobby;
import murach.entity.UserPool;

@WebServlet(name = "BusinessServlet", urlPatterns = {"/Business"})
public class BusinessServlet extends HttpServlet {
    
    
    @Override
    public void init() throws ServletException {
        UserPool userDB = new UserPool();
        getServletContext().setAttribute("UserDB", userDB);
        
        if (getServletContext().getAttribute("initLobby") == null) {
            Lobby initLobby = new Lobby();
            getServletContext().setAttribute("initLobby", initLobby);
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }


}
