<html>
<%@ include file="./util/head.jsp" %>

<body>

<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">

            <ul class="nav navbar-nav">

                <li> <span class="glyphicon glyphicon-check"></span>
                    <fmt:message key="navbar.home"/></li>

                <li class="dropdown">
                    <br>
                    <form>
                    <select id="language" name="language" onchange="submit()">
                        <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
                        <option value="ru" ${language == 'ru' ? 'selected' : ''}>Russian</option>
                    </select>
                    </form>
                </li>

            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/login.jsp">
                    <span class="glyphicon glyphicon-log-in"></span> <fmt:message key="index.link.login" /></a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/registration.jsp"> <span class="glyphicon glyphicon-user"></span>
                    <fmt:message key="index.link.registration" /></a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="headtext"><h1><fmt:message key="index.name.page"/></h1></div>
<br>

<a href="${pageContext.request.contextPath}/allusers">Show Users</a>
<br>

<a href="${pageContext.request.contextPath}/alltests">Show Tests</a>
<br>

<img style="height: 400px;" align="middle" src="${pageContext.request.contextPath}/util/test.jpg" class="rounded mx-auto d-block" alt="Test">

</div><br>

<%@ include file="/util/footer.jsp" %>

</body>
</html>