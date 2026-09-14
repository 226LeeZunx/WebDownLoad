<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Download Site</title>
        <link rel="stylesheet" type="text/css" href="styles/main.css">

    </head>
    <body>
        <h1>Download</h1>
        <h2>DownLoad Site of ${choosingProduct.description}</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>Song Id</th>
                    <th>Song Title</th>
                    <th>Audio Format</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${choosingProduct.downloadLinks}">
                    <tr>
                      <td>${item.id}</td>
                      <td>${item.songName}</td>
                      <td>
                        <a href="${pageContext.request.contextPath}/music/${item.link}" download="${item.link}">
                            MP3
                        </a>
                      </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        
        <form name="backtolobby" action="DangKi" method="POST">
            <input type="hidden" name="action" value="backToLobby" />
            <input type="submit" value="BackToLobby" name="ArtistLobby" />
        </form>
        
        
    </body>
</html>
