 <%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <form method="post" action="SystemUserHome.jsp">
    <div class="login-box" align="center">
    <img src="user.png" class="avatar" >
        <h1>System User Login</h1>
            <p>Username</p>
            <input type="text" name="username" placeholder="Enter Username" required="required">
            <p>Password</p>
            <input type="password" name="password" placeholder="Enter Password" required="required">
            <input type="submit" name="submit" value="Login" >
             <center><h1><a href="Home.jsp">Back</a></h1></center>
        </div> 
            </form>
    <% 
		String error_message = (String) request.getAttribute("error_message");
		if (error_message != null) {
			out.println("<p style='color:red'>" + error_message + "</p>");
		}
	%>
    </body>
</html>