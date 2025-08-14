<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pahana Edu - Billing</title>
    <link rel="stylesheet" href="assets/styles.css"/>
</head>
<body>
<jsp:include page="partials/nav.jsp"/>
<div class="container">
    <h2>Calculate Bill</h2>
    <c:if test="${not empty error}">
        <div class="alert error">${error}</div>
    </c:if>
    <form method="post" action="billing" class="card">
        <label>Select Customer
            <select name="accountNumber" required>
                <option value="" disabled selected>Choose...</option>
                <c:forEach items="${customers}" var="c">
                    <option value="${c.accountNumber}">${c.accountNumber} - ${c.name}</option>
                </c:forEach>
            </select>
        </label>
        <div class="row end mt">
            <button type="submit" class="btn primary">Generate Bill</button>
        </div>
    </form>
</div>
</body>
</html>

