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
            <th>Id</th>
            <th>Name</th>
            <th>E-mail</th>
            <th>Password</th>
            <th>Ball</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${requestScope.userList}" var="userList">
            <tr>
                <td>${userList.id}</td>
                <td>${userList.name}</td>
                <td>${userList.login}</td>
                <td>${userList.password}</td>
                <td>${userList.ball}</td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

    <br>
    <a href="${pageContext.request.contextPath}/alltests">Show Tests</a>
    <br/>

</body>
</html>