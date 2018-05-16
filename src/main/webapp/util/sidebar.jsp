<div class="col-sm-3 sidenav">

    <ul class="nav nav-pills nav-stacked">
        <li class="active"><a href="${pageContext.request.contextPath}/allusers"><fmt:message key="sidebar.userTests" /></a></li>
        <li><a href="${pageContext.request.contextPath}/alltests"><fmt:message key="sidebar.allTests" /></a></li>

    </ul><br>

    <div class="input-group">
        <input type="text" class="form-control" placeholder="<fmt:message key="sidebar.search" />">
        <span class="input-group-btn">
          <button class="btn btn-default" type="button">
            <span class="glyphicon glyphicon-search"></span>
          </button>
        </span>
    </div>
</div>