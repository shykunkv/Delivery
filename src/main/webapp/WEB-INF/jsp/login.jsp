<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<center>
<h1>Login page</h1>
    <br>
<form class="form-signin" action="<spring:url value="/login" />" method="POST">
    <h2 class="form-signin-heading">Please sign in</h2>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <label for="usernamefield" class="sr-only">Username</label>
    <input type="text" id="usernamefield" name="username" class="form-control" placeholder="Username" required autofocus>

    <br>
    <br>
    <label for="passwordfield" class="sr-only">Password</label>
    <input type="password" id="passwordfield" name="password" class="form-control" placeholder="Password" required>

    <br>
    <br>

    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    <br><br>
    or
    <a href="<spring:url value="/jsp/register" />">Register</a>
</form>
</center>
