<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/util/head.jsp" %>

<html>
<body>
<%@ include file="/util/navuser.jsp" %>

<div class="container-fluid">
    <div class="row content">

            <div class="container text-center conteinerd">
                <div class="row">
                    <div class="col-lg-6">

                        <i><fmt:message key="pasttest.count"/> "${requestScope.allTestsCount}"</i>
                        <br>
                        <br>

                        <ul class="list-group">
                            <c:forEach var="test" items="${requestScope.testList}">
                                <li class="list-group-item">
                                    <button class="btn btn-info" data-toggle="collapse" data-target="#${test.id}">
                                        <c:out value="${test.getTest().getCategory()}"/>: <c:out value="${test.getTest().getName()}"/>
                                    </button>

                                    <div id="${test.id}" class="collapse">
                                       <p>
                                          <fmt:message key="pasttest.category"/> <c:out value="${test.getTest().getCategory()}"/>
                                          <br>
                                          <fmt:message key="pasttest.name"/> <c:out value="${test.getTest().getName()}"/>
                                          <br>
                                          <fmt:message key="pasttest.description"/> <c:out value="${test.getTest().getDescription()}"/>
                                          <br>
                                          <fmt:message key="pasttest.datepass"/> <c:out value="${test.datePass}"/>
                                          <br>
                                          <fmt:message key="pasttest.ball"/> <c:out value="${test.ball}"/>
                                       </p>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
            </div>
        </div>
</div>

    <%@ include file="/util/footer.jsp" %>
</body>
</html>