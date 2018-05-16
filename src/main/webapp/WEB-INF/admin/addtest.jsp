<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
</head>
<body>

<h1>Добавить тариф</h1><br/>
<form method="get" action="${pageContext.request.contextPath}/app/addtariff">

    <input type="text" name="name"><br/>
    <input type="text" name="price"><br/>
    <input type="text" name="countMinutes"><br/>
    <input type="text" name="countSms"><br/>
    <br/>
    <input class="button" type="submit" value="Добавить">

</form>
<br/>
<a href="${pageContext.request.contextPath}/app/logout">На головну</a>

</body>
</html>
