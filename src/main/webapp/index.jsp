<!-- САМАЯ ПЕРВАЯ СТРАНИЦА (ВХОД) -->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quizme</title>
    <style>
        body, html {
            height: 100%;
            margin:0px;
            padding:0px;

        }


        .hero-image {
            background-image: linear-gradient(90deg, #aea4e3, #d3ffe8);
            /*background-image: linear-gradient(rgba(220, 90, 120, 0.5), rgba(110, 20, 0, 0.5));*/
            height: 100%;
            top:-20px;
            margin:0px;
            padding:0px;
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
            position: relative;
        }

        /* Place text in the middle of the image */
        .hero-text {
            text-align: center;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            color: black;
        }

        input {
            background-color: dodgerblue;
            width: 250px;

        }

        form {
            padding: 10px;
        }

    </style>
</head>
<jsp:include page="nav.jsp" flush="true" />
<body>
<div class="hero-image">
    <div class="hero-text">
        <h1>Добро пожаловать на обучающую платформу!</h1>
        <h3>Здесь вы узнаете об алгоритмах программирования</h3>
        <br>
       <p>Для проверки знаний рекомендуем проходить тесты, которые открываются после обучения, и решать задачи. </p>
        <br>
         <form action="${pageContext.request.contextPath}/course" method="GET">
        <button type="submit" class="btn btn-primary btn-block">Начать обучение!</button>
        </form>
    </div>
</div>
</body>
</html>