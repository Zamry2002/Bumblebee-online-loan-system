<%-- 
    Document   : AdminHome
    Created on : Mar 21, 2023, 1:52:19 PM
    Author     : ZAMRY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Admin Functionalities</title>
    <link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

  </head>
  <body>
    <header>
      <div class="logo">
        <h1>My Admin Panel</h1>
      </div>
      <nav>
        <ul>
          <li><a href="Customer-list.jsp">Manage Customers Details</a></li>
          <li><a href="AddNewProduct.jsp">Manage Products</a></li>
          <li><a href="#">Settings</a></li>
        </ul>
      </nav>
    </header>
    <main>
      <section>
        <h2>Dashboard</h2>
        <p>Welcome to the dashboard.</p>
      </section>
      <section>
        <h2>Users</h2>
        <table>
          <thead>
            <tr>
              <th>Name</th>
              <th>Email</th>
              <th>Role</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>Zamry Lufar</td>
              <td>zamry@hotmail.com</td>
              <td>Admin</td>
            </tr>
          </tbody>
        </table>
      </section>
      <section>
    </main>
    <footer>
      <p>Copyright © 2023</p>
    </footer>
  </body>
</html>
