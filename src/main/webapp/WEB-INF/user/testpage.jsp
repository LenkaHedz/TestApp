<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/util/head.jsp" %>

<html>
<body>
<%@ include file="/util/navuser.jsp" %>

   <div class="container text-left">
      <div class="row">
         <div class="col-lg-6">

         <div class="headtext"><h1><c:out value="${requestScope.testName}"/></h1></div>
         <br>
         <div class="headtext"><h3><c:out value="${requestScope.num}"/>. <c:out value="${requestScope.question.name}"/></h3></div>
         <br>
         <br>

            <form method="post" action="${pageContext.request.contextPath}/gotest">
               <c:forEach items="${requestScope.answerList}" var="answerList">
                  <div class="form-check">
                     <input type="checkbox" class="form-check-input" name="answerid" value="${answerList.id}">
                     <label class="form-check-label" for="checkbox100">${answerList.name}</label>
                  </div>
               </c:forEach>
               <br>
               <input type='hidden' name='num' value='${requestScope.num}'/>
               <input type='hidden' name='testName' value='${requestScope.testName}'/>
               <input type='hidden' name='idtest' value='${requestScope.idtest}'/>
               <input type='hidden' name='usertestid' value='${requestScope.usertestid}'/>
               <button class="btn btn-info" type="submit"> <fmt:message key="registration.button.confirm"/></button>
             </form>

         </div>
      </div>
   </div>

    <%@ include file="/util/footer.jsp" %>
</body>
</html>