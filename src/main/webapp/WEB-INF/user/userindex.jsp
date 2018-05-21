<%@ include file="/util/head.jsp" %>

<html>
<body>
<%@ include file="/util/navuser.jsp" %>

    <div class="headtext"><h1><fmt:message key="usermenu.helloname"/><c:out value="${user.name}"/></h1></div>
    <div class="headtext"><h2><fmt:message key="usermenu.ball"/><c:out value="${user.ball}"/></h2></div>
    <br>

    <div class = "imgstype"><ul class="nav nav-pills nav-stacked">
        <li><a href="${pageContext.request.contextPath}/usertests"><fmt:message key="sidebar.userTests" /></a></li>
        <li><a href="${pageContext.request.contextPath}/teststogo"><fmt:message key="sidebar.testsToGo" /></a></li>
    </ul></div>
    <br>

    <div class="imgstype"><img style="height: 400px;" src="${pageContext.request.contextPath}/util/user.jpg" class="rounded mx-auto d-block" alt="User"></div>

<%@ include file="/util/footer.jsp" %>
</body>
</html>