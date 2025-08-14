<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pahana Edu - Customer Form</title>
    <link rel="stylesheet" href="assets/styles.css"/>
</head>
<body>
<jsp:include page="partials/nav.jsp"/>
<div class="container">
    <h2><c:out value="${mode=='edit' ? 'Edit Customer' : 'Add Customer'}"/></h2>
    <form method="post" action="customers">
        <label>Account Number
            <input type="text" name="accountNumber" value="${customer.accountNumber}" required <c:if test="${mode=='edit'}">readonly</c:if>/>
        </label>
        <label>Name
            <input type="text" name="name" value="${customer.name}" required/>
        </label>
        <label>Address
            <input type="text" name="address" value="${customer.address}"/>
        </label>
        <label>Telephone
            <input type="text" name="telephone" value="${customer.telephone}"/>
        </label>
        <label>Units Consumed
            <input type="number" name="unitsConsumed" value="${customer.unitsConsumed}" min="0"/>
        </label>
        <div class="row end mt">
            <a href="customers" class="btn">Cancel</a>
            <button type="submit" class="btn primary">Save</button>
        </div>
    </form>
</div>
</body>
</html>

