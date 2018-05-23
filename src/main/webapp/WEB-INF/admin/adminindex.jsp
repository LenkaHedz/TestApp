<%@ include file="/util/head.jsp" %>

<html>
<body>
<%@ include file="/util/navadmin.jsp" %>

    <div class="headtext"><h1><fmt:message key="usermenu.helloname"/><c:out value="${user.name}"/></h1></div>
    <br>

    <div class = "imgstype"><ul class="nav nav-pills nav-stacked">
        <li><a href="${pageContext.request.contextPath}/allusers"><span class="glyphicon glyphicon-ok-sign"></span><fmt:message key="sidebar.allUsers" /></a></li>
        <li><a href="${pageContext.request.contextPath}/alltests"><span class="glyphicon glyphicon-file"></span><fmt:message key="sidebar.allTests" /></a></li>
    </ul></div>
    <br>

    <div class="imgstype"><img style="height: 400px;" src="${pageContext.request.contextPath}/img/admin.jpg" class="rounded mx-auto d-block" alt="Admin"></div>

<%@ include file="/util/footer.jsp" %>
</body>
</html>