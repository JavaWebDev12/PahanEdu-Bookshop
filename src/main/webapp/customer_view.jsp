<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pahana Edu - Customer Details</title>
    <link rel="stylesheet" href="assets/styles.css"/>
    <style>.kv{display:grid;grid-template-columns:160px 1fr;gap:6px 12px}</style>
</head>
<body>
<jsp:include page="partials/nav.jsp"/>
<div class="container">
    <h2>Customer Details</h2>
    <c:if test="${empty customer}">
        <div class="alert error">Customer not found.</div>
        <a href="customers" class="btn">Back</a>
    </c:if>
    <c:if test="${not empty customer}">
        <div class="card">
            <div class="kv">
                <div>Account Number</div><div>${customer.accountNumber}</div>
                <div>Name</div><div>${customer.name}</div>
                <div>Address</div><div>${customer.address}</div>
                <div>Telephone</div><div>${customer.telephone}</div>
                <div>Units Consumed</div><div>${customer.unitsConsumed}</div>
            </div>
            <div class="row mt">
                <a class="btn" href="customers">Back</a>
                <a class="btn" href="customers?action=edit&accountNumber=${customer.accountNumber}">Edit</a>
            </div>
        </div>
    </c:if>
</div>
</body>
</html>

