<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lobby Page</title>
        <link rel="stylesheet" type="text/css" href="styles/main.css">
    </head>
    <body>
        <h1>Băng Đĩa Lậu Hải Ngoại</h1>
        <c:forEach var="item" items="${initLobby.lobbyNow}">
            <a href="DangKi?action=check&amp;productcode=${item.id}">
                ${item.description}
            </a><br>
        </c:forEach>
            
            <c:if test="${cookie.viewHistory.value != null}">
                <p>View HisTory: <strong>${cookie.viewHistory.value}</strong></p>
            </c:if>
         
        
    </body>
    
</html>
