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
                        </tr>
                   </thead>
                   <tbody>
                        <c:forEach items="${requestScope.testList}" var="testList">
                        <tr>
                            <td>${testList.id}</td>
                            <td>${testList.category.getDescription()}</td>
                            <td>${testList.name}</td>
                            <td>${testList.description}</td>
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