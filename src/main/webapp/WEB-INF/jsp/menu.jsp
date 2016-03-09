<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<center>
    <br>
    <h1>Menu page</h1>
    <br>

    <table  border="1">
        <thead>
            <tr>
                <th width="50">ID</th>
                <th width="150">Name</th>
                <th width="150">Type</th>
                <th width="75">Price</th>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <th width="50"></th>
                    <th width="50"></th>
                </sec:authorize>
            </tr>
        </thead>

        <tbody align="center">
            <c:forEach var="pizza" items="${pizzas}">
                <tr>
                    <td>${pizza.id}</td>
                    <td>${pizza.name}</td>
                    <td>${pizza.type}</td>
                    <td>${pizza.price}</td>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
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
                    </sec:authorize>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        </br>
        <a href="<spring:url value="/jsp/create"/>"/>Create new pizza</a>
    </sec:authorize>
</center>

