<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>All Tariffs form</title>
</head>
<body>
<h2>
    This is Tariffs form! <br/>
</h2>
    <i>Count of Tariffs = "${requestScope.countOfTariffs}"</i>
    <br>
    <br>

    <table border=1>
        <thead>
        <tr>
            <th>Name</th>
            <th>Price</th>
            <th>Count of Minutes</th>
            <th>Count of Sms</th>
            <th>Count of Internet</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${requestScope.tariffList}" var="tariffList">
            <tr>
                <td>${tariffList.name}</td>
                <td>${tariffList.price}</td>
                <td>${tariffList.countMinutes}</td>
                <td>${tariffList.countSms}</td>
                <td>${tariffList.countInternet}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

     <br>
         Find by price
         <form method="GET" action="${pageContext.request.contextPath}/searching">
             <input type="text" name="start" size="1">
             <input type="text" name="end" size="1">
             <input type="submit" value="Show" >
         </form>



    <br>
    <a href="${pageContext.request.contextPath}/allusers">Show Clients</a>
    <br/>

</body>
</html>
