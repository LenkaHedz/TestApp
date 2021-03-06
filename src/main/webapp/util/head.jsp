<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="dateFormatter" uri="/customDateFormatter" %>

<c:set var="language" scope="session" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="locale" />
<html lang="${language}">

<head>
    <title>Testing</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8087/test/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="http://localhost:8087/test/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style>
        <%@ include file="../css/style.css" %>
    </style>

</head>
