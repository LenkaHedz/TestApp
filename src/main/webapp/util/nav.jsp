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
                <li>
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
                <li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-in"></span> <fmt:message key="navbar.logout"/> </a></li>
            </ul>
        </div>
    </div>
</nav>
