<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>All Users form</title>
</head>
<body>
<h2>
    This is Users form! <br/>
</h2>
    <i>Count of Users = "${requestScope.countOfUsers}"</i>
    <br>

    <table border=1>
        <thead>
        <tr>
            <th>Name</th>
            <th>Phone Number</th>
            <th>Tariff</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${requestScope.usertList}" var="userList">
            <tr>
                <td>${clientList.username}</td>
                <td>${clientList.password}</td>
                <td>${clientList.name}</td>
                <td>${clientList.course}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <br>
    <a href="${pageContext.request.contextPath}/app/alltariffs">Show Tariffs</a>
    <br/>

</body>
</html>