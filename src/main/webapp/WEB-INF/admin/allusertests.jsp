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

                 <div class="headtext"><h1><fmt:message key="usertests.testbyuser"/><c:out value="${sessionScope.activeUser.name}"/></h1></div>
                 <i><fmt:message key="pasttest.count"/> "${sessionScope.allTestsCount}"</i>
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
                        <c:forEach items="${sessionScope.testList}" var="testList">
                        <tr>
                            <td>${testList.id}</td>
                            <td>${testList.getTest().getCategory().getDescription()}</td>
                            <td>${testList.getTest().getName()}</td>
                            <td>${testList.getTest().getDescription()}</td>
                            <td><dateFormatter:formatDate language="${sessionScope.language}" localDate="${testList.datePass}"/></td>
                            <td>${testList.ball}</td>
                            <td>
                               <form method="post" action="${pageContext.request.contextPath}/sendtomail">
                              <input type='hidden' name='userName' value='${sessionScope.activeUser.name}'/>
                              <input type='hidden' name='userid' value='${sessionScope.activeUser.id}'/>
                                  <button class="btn btn-info" type="submit" name="usertestid" value="${testList.id}"> <fmt:message key="pasttest.sendOnMail"/></button>
                               </form>
                            </td>
                        </tr>
                        </c:forEach>
                   </tbody>
                 </table>
                 </ul>

                 <nav aria-label="pagination">
                      <ul class="pagination justify-content-center">
                          <c:forEach var="number" begin="1" end="${sessionScope.numberOfPages}">
                              <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/allusertests?page=${number}">${number}</a></li>
                          </c:forEach>
                      </ul>
                  </nav>

                 </div>
            </div>
        </div>
    </div>
</div>

    <%@ include file="/util/footer.jsp" %>
</body>
</html>