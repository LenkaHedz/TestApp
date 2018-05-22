<%@ include file="/util/head.jsp" %>

<html>
<body>

<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/gohome"><fmt:message key="navbar.home" /></a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="imgstype"><img style="height: 300px;" src="${pageContext.request.contextPath}/img/error.jpg" class="rounded mx-auto d-block" alt="Error"></div>
<br>

<div class="headtext"><h2><i>Error: <%= exception %></i></div>
</h2>
<br>


</body>
</html>