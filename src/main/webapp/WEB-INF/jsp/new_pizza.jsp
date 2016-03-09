<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new pizza</title>
</head>

<body>
    <form action="addnew" method="post">
        <h2>Add new pizza:</h2>
        <input id="id" type="hidden" name="id" value="${pizza.id}"/>
        Name: <input id="name" type="text" name="name" value="${pizza.name}"/> </br>
        Price: <input id="price" type="number" name="price" value="${pizza.price}"/> </br>
        Type:
            <select id="type" name="type">
                <c:forEach var="pizzaType" items="${types}">
                    <c:choose>
                        <c:when test="${pizzaType == pizza.type}">
                            <option selected="true" value="${pizzaType}">${pizzaType}</option>
                        </c:when>
                        <c:otherwise>
                            <option value="${pizzaType}">${pizzaType}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </br>
        </br>
        <input type="submit" value="Create"> </br>
    </form>
</body>

</html>
