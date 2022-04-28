<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.clarkngo.quizme.web.domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список пользователей</title>
</head>
<jsp:include page="nav.jsp" flush="true" />
<body>


    <table>
                    <thead>
                    <th>ID</th>
                    <th>UserName</th>
                    <th>Password</th>

                    </thead>
                    <c:forEach items="${listUser}" var="user">
                      <tr>
                        <td><c:out value="${user.getEmail()}"/></td>
                        <td><c:out value="${user.getName()}"/></td>
                        <td><c:out value="${user.getUserId()}"/></td>
                      </tr>
                    </c:forEach>
    </table>
</body>
</html>
