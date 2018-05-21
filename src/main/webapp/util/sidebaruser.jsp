<div class="col-sm-3 sidenav">

    <form method="GET" action="${pageContext.request.contextPath}/searchtest">
      <div class="input-group">
        <input type="text" name="name" class="form-control" placeholder="<fmt:message key="sidebar.search"/>">
        <span class="input-group-btn">
          <button class="btn btn-info" type="submit">
            <span class="glyphicon glyphicon-search"></span>
          </button>
        </span>
      </div>
    </form>

    <ul class="nav nav-pills nav-stacked">
        <li><a href="${pageContext.request.contextPath}/usertests"><fmt:message key="sidebar.userTests" /></a></li>
        <li><a href="${pageContext.request.contextPath}/teststogo"><fmt:message key="sidebar.testsToGo" /></a></li>
    </ul><br>
</div>