
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" type="text/css" href="styles/main.css">
        
    </head>
    <body>
        
            
        <h1>Please Register To the Web </h1>
        <c:if test="${Error!=null}">
            ${Error}
        </c:if>
        <form name="FromRegister" action="DangKi" method="POST">
            <label>First Name :</label><br>
            <input type="text" name="firstName" value="${user.firstName}"  required /><br>
            <label>Second Name :</label><br>
            <input type="text" name="lastName" value="${user.lastName}"  required /><br>
            <label>Email :</label><br>
            <input type="email" name="Email" value=""  required /><br>
            
            <input type="hidden" value="addAcc" name="action"/>
            <input type="submit" value="Register" name="add" />
        </form>
    </body>
</html>
