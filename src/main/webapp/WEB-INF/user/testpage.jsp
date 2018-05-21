<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/util/head.jsp" %>

<html>
<body>
<%@ include file="/util/navuser.jsp" %>

   <div class="container text-left">
      <div class="row">
         <div class="col-lg-6">


         <i><fmt:message key="pasttest.count"/> "${requestScope.test.name}"</i>
         <br>
         <i><fmt:message key="pasttest.count"/> "${requestScope.num}" "${requestScope.question.name}"</i>
         <br>

                       <table id="example" class="table table-striped table-bordered" style="width:100%">
                            <thead>
                                 <tr>
                                     <th><fmt:message key="pasttest.name"/></th>
                                     <th><fmt:message key="pasttest.action"/></th>
                                 </tr>
                            </thead>
                            <tbody>
                                 <c:forEach items="${requestScope.answerList}" var="answerList">
                                 <tr>
                                     <td>${answerList.name}</td>
                                     <td>
                                        <form method="post" action="${pageContext.request.contextPath}/gotest">
                                           <button class="btn btn-info" type="submit" name="answerid"  value="${answerList.id}"> <fmt:message key="pasttest.pastTest"/></button>
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

    <%@ include file="/util/footer.jsp" %>
</body>
</html>