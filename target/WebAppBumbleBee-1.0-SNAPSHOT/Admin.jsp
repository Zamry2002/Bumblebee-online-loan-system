<%-- 
    Document   : Admin
    Created on : Mar 20, 2023, 9:12:56 PM
    Author     : ZAMRY
--%>      
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">   
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>
    <form method="post" action="<%=request.getContextPath()%>/login">
    <div class="login-box" align="center">
        <h1>Admin Login</h1>
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

