<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/util/head.jsp" %>

<html>
<body>
<%@ include file="/util/navuser.jsp" %>

</script>

   <div class="container text-left">
      <div class="row">
         <div class="col-lg-6">

         <div class="headtext"><h1><c:out value="${sessionScope.testName}"/></h1></div>
         <br>
         <div class="headtext"><h3><c:out value="${sessionScope.num}"/>. <c:out value="${sessionScope.question.name}"/></h3></div>
         <br>
         <div class="headtext"><h4><fmt:message key="answers.count"/> <c:out value="${sessionScope.correctAnswers}"/></h4></div>
         <br>

            <form method="post" action="${pageContext.request.contextPath}/gotest">
               <c:forEach items="${sessionScope.answerList}" var="answerList">
                  <div class="form-check">
                     <input type="checkbox" class="form-check-input" id="checkbox100" name="answerid" value="${answerList.id}">
                     <label class="form-check-label" for="checkbox100">${answerList.name}</label>
                  </div>
               </c:forEach>
               <br>
               <button class="btn btn-info" type="submit" name="confirm" value="1"> <fmt:message key="registration.button.confirm"/></button>
             </form>

         </div>
      </div>
   </div>

    <%@ include file="/util/footer.jsp" %>
</body>
</html>