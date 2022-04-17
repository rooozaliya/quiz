<%--
  Created by IntelliJ IDEA.
  User: clark
  Date: 4/20/2021
  Time: 1:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/">Тесты!</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}/">Главная</a></li>
                <li><a href="${pageContext.request.contextPath}/login-form">Вход</a></li>
                <li><a href="${pageContext.request.contextPath}/register-form">Регистрация</a></li>
                <li><a href="${pageContext.request.contextPath}/feedback-form">Обратная связь</a></li>
                <li><a href="${pageContext.request.contextPath}/contact-form">Контакты</a></li>
                <li><a href="${pageContext.request.contextPath}/profile">Profile</a></li>
                 <li><a href="${pageContext.request.contextPath}/admin">Admin</a></li>
            </ul>
        </div>
    </nav>
</body>
</html>
