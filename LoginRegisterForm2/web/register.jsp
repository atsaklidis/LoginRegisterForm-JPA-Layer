<%-- 
    Document   : register
    Created on : 31 Οκτ 2019, 2:29:00 μμ
    Author     : Tsak
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <link rel="stylesheet" href="styling.css">
    </head>
    <body>
        <form action="CustomerController" method="POST">
            <table class="register_objects">
                <tr><td class ="register_headline">Welcome to register page</td></tr>
                <tr><td><input class="forms" type="text" name="username" placeholder="Prefered username"></td></tr>
                <tr><td><input class="forms" type="text" name="first_name" placeholder="Your first name"></td></tr>
                <tr><td><input class="forms" type="text" name="last_name" placeholder="Your last name"></td></tr>
                <tr><td><input class="forms" type="email" name="email" placeholder="Your e-mail"></td></tr>
                <tr><td><input class="forms" type="password" name="password" placeholder="Your password"></td></tr>
                <tr><td><input class="forms" type="password" name="password2" placeholder="Re-enter your password"></td></tr>
                <tr><td><input class="button" type="submit" name="submit" value="Sign Up"></td></tr>
                <tr><td class ="fail_message">${missing_info_message}</td></tr>
                <tr><td class ="fail_message">${user_exists_message}</td></tr>
                <tr><td class ="login_text">Remembered your account? Go back to login page <a href="index.jsp">here</a>.</td></tr>
           </table>
        </form>
    </body>
</html>
