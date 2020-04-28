<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>Stack Digest</title>
</head>

    <body>
        ${SPRING_SECURITY_LAST_EXCEPTION.message}
        User: <input type="text" name="username" value=""/>
        Password:
    </body>
</html>
