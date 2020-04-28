<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Stack Digest</title>
    </head>

    <body>

        <form:form action="registerUser" modelAttribute="newuser">
            User id: <form:input path="id" /> <br>
            Password: <form:password path="password"/> <br>
            <input type="submit" value="Submit">
        </form:form>
    </body>
</html>
