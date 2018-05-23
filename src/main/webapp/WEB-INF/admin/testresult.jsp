<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/util/head.jsp" %>

<html>
<body>
<%@ include file="/util/navadmin.jsp" %>

<div class="container-fluid">
    <div class="row content">
        <div class="container text-center conteinerd">
            <div class="row">
                 <div class="col-lg-7">

                 <div class="headtext"><h1><c:out value="${requestScope.testName}"/></h1></div>
                 <br>

                 <i><fmt:message key="pasttest.ball"/> "${requestScope.allBallCount}"</i>
                 <br>
                 <br>

                 <table id="example" class="table table-striped table-bordered" style="width:100%">
                   <thead>
                        <tr>
                            <th><fmt:message key="pasttest.num"/></th>
                            <th><fmt:message key="pasttest.name"/></th>
                            <th><fmt:message key="pasttest.ball"/></th>
                        </tr>
                   </thead>
                   <tbody>
                        <c:forEach items="${requestScope.userAnswerList}" var="userAnswerList">
                        <tr>
                            <td>${userAnswerList.id}</td>
                            <td>${userAnswerList.getAnswer().getName()}</td>
                            <td>${userAnswerList.getAnswer().getBall()}</td>
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