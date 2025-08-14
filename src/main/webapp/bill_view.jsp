<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pahana Edu - Bill</title>
    <link rel="stylesheet" href="assets/styles.css"/>
    <style>.bill{max-width:720px;margin:auto}</style>
</head>
<body>
<jsp:include page="partials/nav.jsp"/>
<div class="container bill">
    <div class="card">
        <h2>Bill</h2>
        <p><strong>Customer:</strong> ${customer.name} (${customer.accountNumber})</p>
        <p><strong>Units Consumed:</strong> ${units}</p>
        <h3>Total Amount: Rs. ${amount}</h3>
        <div class="row mt">
            <button onclick="window.print()" class="btn">Print</button>
            <a href="billing" class="btn">Back</a>
        </div>
    </div>
</div>
</body>
</html>

