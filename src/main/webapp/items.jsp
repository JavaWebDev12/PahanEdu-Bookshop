<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pahana Edu - Items</title>
    <link rel="stylesheet" href="assets/styles.css"/>
</head>
<body>
<jsp:include page="partials/nav.jsp"/>
<div class="container">
    <div class="row between">
        <h2>Items</h2>
        <a class="btn" href="items?action=create">Add Item</a>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Unit Price</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${items}" var="i">
            <tr>
                <td>${i.id}</td>
                <td>${i.name}</td>
                <td>${i.unitPrice}</td>
                <td>
                    <a class="btn small" href="items?action=edit&id=${i.id}">Edit</a>
                    <a class="btn small danger" href="items?action=delete&id=${i.id}" onclick="return confirm('Delete this item?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <p class="muted">Items are used for general product management in the bookshop.</p>
    </div>
</body>
</html>

