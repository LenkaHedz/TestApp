<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/util/head.jsp" %>

<html>
<body>
<%@ include file="/util/navuser.jsp" %>

<div class="container-fluid">
    <div class="row content">
        <div class="container text-center conteinerd">
            <div class="row">
                 <div class="col-lg-7">

                 <i><fmt:message key="pasttest.count"/> "${requestScope.allTestsCount}"</i>
                 <br>
                 <br>

                 <table id="example" class="table table-striped table-bordered" style="width:100%">
                   <thead>
                        <tr>
                            <th><fmt:message key="pasttest.num"/></th>
                            <th><fmt:message key="pasttest.category"/></th>
                            <th><fmt:message key="pasttest.name"/></th>
                            <th><fmt:message key="pasttest.description"/></th>
                            <th><fmt:message key="pasttest.datepass"/></th>
                            <th><fmt:message key="pasttest.ball"/></th>
                            <th><fmt:message key="pasttest.action"/></th>
                        </tr>
                   </thead>
                   <tbody>
                        <c:forEach items="${requestScope.testList}" var="testList">
                        <tr>
                            <td>${testList.id}</td>
                            <td>${testList.getTest().getCategory().getDescription()}</td>
                            <td>${testList.getTest().getName()}</td>
                            <td>${testList.getTest().getDescription()}</td>
                            <td><ctg:format-date date="${testList.datePass}" language="${sessionScope.language}"/></td>
                            <td>${testList.ball}</td>
                            <td>
                               <form method="post" action="${pageContext.request.contextPath}/sendtomail">
                                  <button class="btn btn-info" type="submit" name="usertestid" value="${testList.id}"> <fmt:message key="pasttest.sendOnMail"/></button>
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