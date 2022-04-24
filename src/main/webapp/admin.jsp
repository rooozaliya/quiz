<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin страница</title>
</head>
<jsp:include page="nav.jsp" flush="true" />
<body>
username
<c:forEach items="${getUserId}" var="getUserId">
        <tr>
              <td>${user.id}</td>
              <td>${user.username}</td>
              <td>${user.password}</td>
        </tr>
    </c:forEach>
</body>
</html>
