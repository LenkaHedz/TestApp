<html>
<%@ include file="./util/head.jsp" %>

<%!
String getFormattedDate(){
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
    return sdf.format(new Date());
}
%>

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

                <li class="active"><a href="${pageContext.request.contextPath}/index.jsp"> <fmt:message key="navbar.home" /> </a></li>

                <li>Date: <%= getFormattedDate() %></li>

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

<a href="${pageContext.request.contextPath}/allusers">Show Users</a>


<img src="${pageContext.request.contextPath}/util/test.jpg" class="rounded mx-auto d-block" alt="Test">

</div><br>

<%@ include file="/util/footer.jsp" %>

</body>
</html>