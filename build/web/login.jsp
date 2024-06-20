<%-- 
    Document   : login
    Created on : 19 juin 2024, 23:04:15
    Author     : Perfectus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="${pageContext.request.contextPath}/LoginServlet">
            <p>
                <label>Username: </label>
                <input type="text" name="username">
            </p>
            <p>
                <label>Mot de passe: </label>
                <input type="password" name="pwd">
            </p>
            <p><input type="submit" value="Connection"></p>
        </form>
    </body>
</html>
