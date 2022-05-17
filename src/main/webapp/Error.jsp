
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
 <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style><%@include file="/css/login.css"%></style>
    <title>Title</title>
</head>
<body>
<jsp:include page="nav.jsp" flush="true" />
<div class="error-form">
    <form action="${pageContext.request.contextPath}/error" method="POST">
        <h2 class="text-center">Похоже, вы не авторизованы :( </h2>
    </form>
    <p class="text-center"><a href="${pageContext.request.contextPath}/login">Войти!</a></p>
    <p class="text-center"><a href="${pageContext.request.contextPath}/register-form">Нет аккаунта? Создай его!</a></p>
</div>
</body>
</html>
