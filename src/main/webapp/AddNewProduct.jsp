<%-- 
    Document   : AddNewProduct
    Created on : Apr 4, 2023, 4:49:35 PM
    Author     : ZAMRY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Product</title>
        <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
    </head>
    <body>
        <h1>Add New Product</h1>
        <div style="width:900px; margin-left:auto; margin-right: auto">
        <form action="ManagerAddNew.jsp" method="post">
            Product Name:<br>
            <input type="text" name="name" style="width:200px"><br>
             Product Price:<br>
            <input type="text" name="price" style="width:200px"><br>
             Product Description:<br>
            <input type="text" name="description" style="width:200px"><br>
            <input type="submit" value="Submit">
        </form>
        </div>
    </body>
</html>
