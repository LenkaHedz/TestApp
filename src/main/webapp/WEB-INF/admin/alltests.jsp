<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>All Tests form</title>
</head>
<body>
<h2>
    This is Tests form! <br/>
</h2>

     <br>
         Find by name
         <form method="GET" action="${pageContext.request.contextPath}/searchtest">
             <input type="text" name="name" size="125">
             <input type="submit" value="Show" >
         </form>

    <br>

    <i>Count of Tariffs = "${requestScope.allTestsCount}"</i>
    <br>
    <br>

    <table border=1>
        <thead>
        <tr>
            <th>Id</th>
            <th>Category</th>
            <th>Name</th>
            <th>Description</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${requestScope.testList}" var="testList">
            <tr>
                <td>${testList.id}</td>
                <td>${testList.category}</td>
                <td>${testList.name}</td>
                <td>${testList.description}</td>
                <td>
                  <form method="post" action="${pageContext.request.contextPath}/gotest">
                    <button class="btn btn-info" type="submit">Go test</button>
                   </form>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

    <br>
    <a href="${pageContext.request.contextPath}/allusers">Show Users</a>
    <br/>

</body>
</html>
