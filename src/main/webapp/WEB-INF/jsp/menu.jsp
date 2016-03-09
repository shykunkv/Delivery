<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<center>
<br>

    <h3>PizzaDelivery Menu</h3>


    <table  border="1">
        <thead>
            <tr>
                <th width="50">ID</th>
                <th width="150">Name</th>
                <th width="150">Type</th>
                <th width="75">Price</th>
                <th width="50"></th>
                <th width="50"></th>
            </tr>
        </thead>

        <tbody align="center">
            <c:forEach var="pizza" items="${pizzas}">
                <tr>
                    <td>${pizza.id}</td>
                    <td>${pizza.name}</td>
                    <td>${pizza.type}</td>
                    <td>${pizza.price}</td>
                    <td>
                        <form action="edit" method="post">
                            <input type="hidden" name="id" value="${pizza.id}" />
                            <input type="submit" name="edit" value="edit"/>
                        </form>
                    </td>
                    <td>
                        <form action="delete" method="post">
                            <input type="hidden" name="id" value="${pizza.id}" />
                            <input type="submit" name="delete" value="delete"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    </br>
    <a href="/jsp/create">Create new pizza</a>
</center>

