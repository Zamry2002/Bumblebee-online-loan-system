<%-- 
    Document   : Admin
    Created on : Mar 20, 2023, 9:12:56 PM
    Author     : ZAMRY
--%>
<%@page import="com.my.webappbumblebee.adminlogin"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">   
  <link rel="stylesheet" type="text/css" href="main.css">  
  <style>
  .login-box{
    height: 380px;
}</style>
</head>
<body>
    <form method="post" action="AdminHome.jsp">
    <div class="login-box" align="center">
    <img src="user.png" class="avatar" >
        <h1>Admin Login</h1>
            <p>Username</p>
            <input type="text" name="username" placeholder="Enter Username" required="required">
            <p>Password</p>
            <input type="password" name="password" placeholder="Enter Password" required="required">
            <p>Confirm Password </p>
            <input type="password" name="conpassword" placeholder="Confirm Password" required="required">
            <br></br>
            <input type="submit" name="submit" value="Login" >
            </form>
             <center><h1><a href="Home.jsp">Back</a></h1></center>
        </div> 
    </body>
</html>

