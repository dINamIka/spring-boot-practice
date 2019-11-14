<!DOCTYPE html>

<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Data page</title>
</head>
<body>

<div>
    <h><b>Stock details</b></h>
    <p><c:out value="${test}"/></p>
    <table>
        <tr>
            <th>Item ID</th>
            <th>Name</th>
            <th>Price</th>
        </tr>
        <c:forEach var="it" items="${items}">
            <tr>
                <td><c:out value="${it.id}"/></td>
                <td><c:out value="${it.name}"/></td>
                <td><c:out value="${it.price}"/></td>
            </tr>
        </c:forEach>

    </table>
</div>


</body>
</html>