<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/util/head.jsp" %>

<html>
<body>
<%@ include file="/util/navadmin.jsp" %>

<div class="container-fluid">
    <div class="row content">
        <div class="container text-center conteinerd">
            <div class="row">
                 <div class="col-lg-6">

                 <i><fmt:message key="users.count"/> "${requestScope.allUsersCount}"</i>
                 <br>
                 <br>

                 <table id="example" class="table table-striped table-bordered" style="width:100%">
                   <thead>
                        <tr>
                            <th><fmt:message key="pasttest.num"/></th>
                            <th><fmt:message key="pasttest.name"/></th>
                            <th><fmt:message key="pasttest.login"/></th>
                            <th><fmt:message key="pasttest.password"/></th>
                            <th><fmt:message key="pasttest.ball"/></th>
                            <th><fmt:message key="pasttest.action"/></th>
                        </tr>
                   </thead>
                   <tbody>
                        <c:forEach items="${requestScope.userList}" var="userList">
                        <tr>
                            <td>${userList.id}</td>
                            <td>${userList.name}</td>
                            <td>${userList.login}</td>
                            <td>${userList.password}</td>
                            <td>${userList.ball}</td>
                            <td>
                               <form method="post" action="${pageContext.request.contextPath}/usertestsadmin">
                                  <button class="btn btn-info" type="submit" name="userid" value="${userList.id}"> <fmt:message key="pasttest.userTests"/></button>
                               </form>
                            </td>
                        </tr>
                        </c:forEach>
                   </tbody>
                 </table>
                 </ul>

                 </div>
            </div>
        </div>
    </div>
</div>

    <%@ include file="/util/footer.jsp" %>
</body>
</html>