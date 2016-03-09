<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<center>
<body>
    <h1>Register page</h1>
    <br>

    <form class="form-signin" action="<spring:url value="/jsp/register" />" method="POST">
        <h2 class="form-signin-heading">Registration</h2>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <label for="usernamefield" class="sr-only">Username</label>
        <input type="text" id="usernamefield" name="login" class="form-control" placeholder="Login" required autofocus>


        <br><br>
        <label for="passwordfield" class="sr-only">Password</label>
        <input type="password" id="passwordfield" name="password" class="form-control" placeholder="Password" required>

        <br><br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
    </form>
</body>
</center>
