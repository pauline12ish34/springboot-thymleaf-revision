<jsp:include page="../components/header.jsp"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div class="container">
    <div class="container">
        <button class="btn btn-primary" onclick="window.location.href='/items/add-page'">Add Item</button>
    </div>
    <c:forEach items="${items}" var="item">
        <div class="container p-4 m-4 bg-primary  text-light">
            <p>name:${item.name}</p>
            <p>quantity: ${item.quantity}</p>
            <p> price: ${item.price}</p>
<%--            <input type="button" class="btn btn-danger" value="delete" onclick="window.location.href='/students/delete?id=${student.id}'"/>--%>
<%--            <input type="button" class="btn btn-primary" value="edit" onclick="window.location.href='/students/edit-page?id=${student.id}'" />--%>
        </div>
    </c:forEach>
</div>

</body>
</html>