<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/util/head.jsp" %>

<html>
<body>
<%@ include file="/util/nav.jsp" %>

<div class="container-fluid">
    <div class="row content">

        <%@ include file="/util/sidebar.jsp" %>

            <div class="container text-center">
                <div class="row">
                    <div class="col-lg-6">

                        <br>
                           Find by name
                             <form method="GET" action="${pageContext.request.contextPath}/searchtest">
                                <input type="text" name="name" size="125">
                                <input type="submit" value="Show" >
                             <button class="btn btn-info" type="submit">Sort</button>
                             </form>
                        <br>

                        <i>Count of Tariffs = "${requestScope.allTestsCount}"</i>
                        <br>
                        <br>


                        <ul class="list-group">
                            <c:forEach var="test" items="${requestScope.testList}">
                                <li class="list-group-item">
                                    <button class="btn btn-info" data-toggle="collapse" data-target="#${test.id}">
                                        <c:out value="${test.id}"/> :  <c:out value="${account.balance}"/>
                                    </button>

                                    <div id="${test.id}" class="collapse">
                                            <p>
                                                Category: <c:out value="${test.category}"/> ;
                                                <br>
                                                Name: <c:out value="${test.name}"/> ;
                                                <br>
                                                Description:  <c:out value="${test.description}"/>
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