<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pahana Edu - Login</title>
    <link rel="stylesheet" href="assets/styles.css"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <style>body{display:flex;align-items:center;justify-content:center;min-height:100vh}</style>
    <script>history.replaceState && history.replaceState(null, null, location.href);</script>
    <noscript><style>.requires-js{display:none}</style></noscript>
    <meta http-equiv="Cache-Control" content="no-store"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>
    <link rel="icon" href="assets/favicon.ico"/>
    <meta name="robots" content="noindex"/>
</head>
<body>
<div class="card" style="max-width:420px;width:100%">
    <h2>Login</h2>
    <c:if test="${not empty error}">
        <div class="alert error">${error}</div>
    </c:if>
    <form method="post" action="login">
        <label>Username
            <input type="text" name="username" required autofocus/>
        </label>
        <label>Password
            <input type="password" name="password" required/>
        </label>
        <div class="row between mt">
            <a href="help.jsp">Help</a>
            <button type="submit" class="btn primary">Sign In</button>
        </div>
    </form>
</div>
</body>
</html>

