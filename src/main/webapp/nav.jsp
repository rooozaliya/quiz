<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Title</title>
    <meta charset="UTF-8">
    <style>
        .space{
            padding-left:350px;}
    </style>
</head>

<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">Главная</a>
        </div>
        <ul class="nav navbar-nav">
            <li ><a href="${pageContext.request.contextPath}/profile"> <b>Привет! <c:out value="${name}"/></b></a></li>



            <c:choose>
                <c:when test="${name==null}">
                    <li class="space"><a href="${pageContext.request.contextPath}/login">Вход</a></li>
                    <li ><a href="${pageContext.request.contextPath}/register">Регистрация</a></li>
                </c:when>
                <c:when test="${username=='rainurl@mail.ru'}">
                    <li><a href="${pageContext.request.contextPath}"> Баллы: ${ball}</a></li>
                    <li><a href="${pageContext.request.contextPath}/course">Курсы</a></li>
                    <li><a href="${pageContext.request.contextPath}/feedback">Обратная связь</a></li>
                    <li><a href="${pageContext.request.contextPath}/admin-form">Админка</a></li>
                    <li><a href="${pageContext.request.contextPath}/add-task">Добавить задачи</a></li>
                    <li><a href="${pageContext.request.contextPath}/ball">Рейтинг студентов</a></li>
                    <li class="space"><a href="${pageContext.request.contextPath}/logout">Выйти</a></li>
                </c:when>

                <c:when test="${name!=null}">
                    <li><a href="${pageContext.request.contextPath}"> Баллы: ${ball}</a></li>
                    <li><a href="${pageContext.request.contextPath}/course">Курсы</a></li>
                    <li><a href="${pageContext.request.contextPath}/feedback">Обратная связь</a></li>
                    <li><a href="${pageContext.request.contextPath}/ball">Рейтинг студентов</a></li>
                    <li class="space"><a href="${pageContext.request.contextPath}/logout">Выйти</a></li>
                </c:when>

                <c:otherwise>

                </c:otherwise>
            </c:choose>



        </ul>
    </div>
</nav>
</body>


</html>