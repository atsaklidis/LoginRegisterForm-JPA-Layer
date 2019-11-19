<%-- 
    Document   : index
    Created on : 31 Οκτ 2019, 1:56:01 μμ
    Author     : Tsak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="styling.css">
    </head>
    <body>
        
        <form action="CustomerController" method="POST">
            <table class="login_objects">
                <tr><td class ="register_headline">Welcome to the login page</td></tr>
                <tr><td><input class="forms" type="text" name="username" placeholder="Username"></td></tr>
                <tr><td><input class="forms" type="password" name="password" placeholder="Password"></td></tr>
                <tr><td><input class="button" type="submit" name="submit" value="Sign In"></td></tr>
                <tr><td class ="fail_message">${user_not_exist_message}</td></tr>
                <tr><td class ="fail_message">${wrong_password_message}</td></tr>
                <tr><td class ="register_text">Don't have an account? Create one <a href="register.jsp">here</a>.</td></tr>
            </table>
        </form>
    </body>
</html>
