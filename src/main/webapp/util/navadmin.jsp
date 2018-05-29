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
                <li>
                    <br>
                    <span class="glyphicon glyphicon-check"></span>
                </li>

                <li>
                    <br>
                       <form>
                           <select id="language" name="language" onchange="submit()">
                                <option value="en_US" ${language == 'en_US' ? 'selected' : ''}><fmt:message key="language.en"/></option>
                                <option value="ru_RU" ${language == 'ru_RU' ? 'selected' : ''}><fmt:message key="language.ru"/></option>
                           </select>
                       </form>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/gohome"><fmt:message key="navbar.home" /></a></li>
                <li><a href="${pageContext.request.contextPath}/allusers"><fmt:message key="sidebar.allUsers" /></a></li>
                <li><a href="${pageContext.request.contextPath}/alltests"><fmt:message key="sidebar.allTests" /></a></li>
                <li><a href="${pageContext.request.contextPath}/logout"><span class="glyphicon glyphicon-log-in"></span> <fmt:message key="navbar.logout"/> </a></li>
            </ul>
        </div>
    </div>
</nav>
