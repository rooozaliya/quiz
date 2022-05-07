<!-- СПИСОК ТЕСТОВ (ТРИ ШТУКИ) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.clarkngo.quizme.web.domain.QuizType" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Тесты</title>
      <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">



</head>

<body>
    <div class="container">
        <div class="row">

            <c:forEach var="quizType" items="${quizTypeList}">
                <div class="col-sm-4">
                    <div class="card border-primary mb-3" style="max-width: 25rem;">

                       <!-- <img class="card-img-top" src="${quizType.getImageUrl()}" alt="Card image" width="100%" height="200">-->
                       <!--<img class="card-img-top" src="${pageContext.request.contextPath}/resourses/img/2.png" alt="Card" width="100%" height="200">-->
                        <img class="card-img-top" src="${pageContext.request.contextPath}/resourses/img/${quizType.getQuizTypeId()}.png" alt="Card" width="100%" height="200">
                        <div class="card-body">
                         <h4 class="card-title"><c:out value="${quizType.getQuizTypeId()}"/></h4>
                            <h4 class="card-title"><c:out value="${quizType.getName()}"/></h4>
                            <p class="card-text"><c:out value="${quizType.getDescription()}"/></p>
                            <form action="${pageContext.request.contextPath}/quiz" method="GET">
                                <div class="form-group">
                                    <input type="hidden" class="form-control" name="quizTypeId" value="${quizType.getQuizTypeId()}">
                                </div>
                                <div class="form-group">
                                    <input type="hidden" class="form-control" name="page" value="1">
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-block">Приступить к тестированию</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
