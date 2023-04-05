<%-- 
    Document   : CustomerRegistration
    Created on : Mar 28, 2023, 1:53:39 PM
    Author     : ZAMRY
--%>
   <%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
    
    <img src="../1.jpg" />
    <title>Customer Registration</title>
</head>
<body>
    <div align="center">
        <form action="<%=request.getContextPath()%>/register" method="post">
            <table style="with: 80%">
                <tr>
                    <td>Full Name</td>
                    <td><input type="text" name="full_name"/></td>
                </tr>
                <tr>
                    <td>Date Of Birth</td>
                    <td><input type="text" name="date_of_birth"/></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email"/></td>
                </tr>
                <tr>
                    <td>Age</td>
                    <td><input type="text" name="age"/></td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td><input type="text" name="gender"/></td>
                </tr>
            </table>
            <input type="submit" value="Register"/>
        </form>
    </div>
</body>
</html>
