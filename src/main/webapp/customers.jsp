<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pahana Edu - Customers</title>
    <link rel="stylesheet" href="assets/styles.css"/>
</head>
<body>
<jsp:include page="partials/nav.jsp"/>
<div class="container">
    <div class="row between">
        <h2>Customers</h2>
        <a class="btn" href="customers?action=create">Add Customer</a>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th>Account #</th>
            <th>Name</th>
            <th>Address</th>
            <th>Telephone</th>
            <th>Units</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${customers}" var="c">
            <tr>
                <td><a href="customers?action=view&accountNumber=${c.accountNumber}">${c.accountNumber}</a></td>
                <td>${c.name}</td>
                <td>${c.address}</td>
                <td>${c.telephone}</td>
                <td>${c.unitsConsumed}</td>
                <td>
                    <a class="btn small" href="customers?action=edit&accountNumber=${c.accountNumber}">Edit</a>
                    <a class="btn small danger" href="customers?action=delete&accountNumber=${c.accountNumber}" onclick="return confirm('Delete this customer?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>

