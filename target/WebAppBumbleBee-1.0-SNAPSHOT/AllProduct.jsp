<%-- 
    Document   : AllPostProduct
    Created on : Apr 4, 2023, 5:11:18 PM
    Author     : ZAMRY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Products</title>
        <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
    </head>
    <body>
        <div style="width:1200px; margin-left:auto; margin-right: auto;">
            <table cellpadding="10">
                <tr>
                    <th>ID</th>
						<th>Name</th>
                                                <th>Price</th>
                                                <th>Description</th>
						<th></th>
                </tr>
                <c:forEach items="${AllProduct}" var="p">
                    <tr>
							<td>${p.id}"</td>
                                                        <td>${p.name}"</td>
                                                        <td>${p.price}"</td>
                                                        <td>${p.description}"</td
                                                        <td>
                                                            <a href="edit?id=${p.id}">Edit</a>
                                                                <a href="delete?id=${p.id}">Delete</a>
                                                        </td>                                    
                                                        
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
