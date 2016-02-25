<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/24/16
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
    <h3>PizzaDelivery Menu</h3>

    <table border="1" width="300">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Type</th>
                <th>Price</th>
            </tr>
        </thead>

        <tbody align="center">
            <c:forEach var="pizza" items="${pizzas}">
                <tr>
                    <td>${pizza.id}</td>
                    <td>${pizza.name}</td>
                    <td>${pizza.type}</td>
                    <td>${pizza.price}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
