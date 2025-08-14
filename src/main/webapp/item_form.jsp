<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pahana Edu - Item Form</title>
    <link rel="stylesheet" href="assets/styles.css"/>
</head>
<body>
<jsp:include page="partials/nav.jsp"/>
<div class="container">
    <h2><c:out value="${mode=='edit' ? 'Edit Item' : 'Add Item'}"/></h2>
    <form method="post" action="items">
        <label>ID
            <input type="text" name="id" value="${item.id}" required <c:if test="${mode=='edit'}">readonly</c:if>/>
        </label>
        <label>Name
            <input type="text" name="name" value="${item.name}" required/>
        </label>
        <label>Unit Price
            <input type="number" step="0.01" name="unitPrice" value="${item.unitPrice}" required/>
        </label>
        <div class="row end mt">
            <a href="items" class="btn">Cancel</a>
            <button type="submit" class="btn primary">Save</button>
        </div>
    </form>
    </div>
</body>
</html>

