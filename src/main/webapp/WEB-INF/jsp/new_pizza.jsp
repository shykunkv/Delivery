<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2/24/16
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new pizza</title>
</head>
<body>

    <form action="addnew" method="post">
        <h2>Add new pizza:</h2>
        <input type="hidden" name="id" value="${pizza.id}"/>
        Name: <input type="text" name="name" value="${pizza.name}"/> </br>
        Price: <input type="text" name="price" value="${pizza.price}"/> </br>
        Type: <input type="text" name="type" value="${pizza.type}"/> </br>
        </br>
        <input type="submit" value="Create"> </br>
    </form>
</body>
</html>
