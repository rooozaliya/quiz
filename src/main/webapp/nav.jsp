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
                <li><a href="${pageContext.request.contextPath}/course">Курсы</a></li>
                <li><a href="${pageContext.request.contextPath}/chat">Чат</a></li>
                <li><a href="${pageContext.request.contextPath}/feedback-form">Обратная связь</a></li>
                <li><a href="${pageContext.request.contextPath}/contact-form">Контакты</a></li>
                <li ><a href="${pageContext.request.contextPath}/login-form">Вход</a></li>
                <li ><a href="${pageContext.request.contextPath}/register-form">Регистрация</a></li>
                <li><a href="${pageContext.request.contextPath}/admin-form">Админка</a></li>
                <li><a href="${pageContext.request.contextPath}/logout">Выйти</a></li>
            </ul>
        </div>
    </nav>
</body>


</html>
