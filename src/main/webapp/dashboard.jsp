<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pahana Edu - Dashboard</title>
    <link rel="stylesheet" href="assets/styles.css"/>
</head>
<body>
<jsp:include page="partials/nav.jsp"/>
<div class="container">
    <h2>Welcome, <c:out value="${sessionScope.user}"/></h2>
    <div class="grid">
        <a class="card link" href="customers">Manage Customers</a>
        <a class="card link" href="items">Manage Items</a>
        <a class="card link" href="billing">Calculate Bill</a>
        <a class="card link" href="help.jsp">Help</a>
    </div>
</div>
</body>
</html>

