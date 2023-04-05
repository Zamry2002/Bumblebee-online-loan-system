<%-- 
    Document   : ManagerAddNew
    Created on : Apr 4, 2023, 5:26:17 PM
    Author     : ZAMRY
--%>

<%@page import="com.my.webappbumblebee.manage.ProductAccess"%>
<%@page import="com.my.webappbumblebee.manage.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String name =request.getParameter("name");
            String price= request.getParameter("price");
            String description= request.getParameter("description");
            
            Product product= new Product(0,name,price,description);
            ProductAccess productAccess = new ProductAccess();
            productAccess.addNew(product);
            
            response.sendRedirect("AllProduct.jsp");
             
            %>
            
    </body>
</html>
