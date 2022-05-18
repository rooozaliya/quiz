<!-- ЭТО СТРАНИЦА ОТОБРАЖЕНИЯ ЗАДАЧ -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.clarkngo.quizme.web.domain.task.TaskType" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page buffer="none" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .content { margin-top:50px; text-align:center; }
        .header {padding:15px; position:fixed; top:0; width:100%; z-index:9999; }
        .left-title { width:80px; color:#FFF; font-size:18px; float:left; }
        .right-title { width:150px; text-align:right; float:right; color:#FFF;  }
        .quiz-body { margin-top:15px; padding-bottom:50px; max-width:420px;  float:center;}
        .option-block-container { margin-top:20px; max-width:420px; }
        .option-block { padding:10px; background:aliceblue; border:1px solid #84c5fe; margin-bottom:10px; cursor:pointer; }
        .result-question { font-weight:bold; }
        .c-wrong { margin-left:20px; color:#FF0000; }
        .c-correct {  margin-left:20px; color:green; }
        .last-row { border-bottom:1px solid #ccc; padding-bottom:25px; margin-bottom:25px; }
        .res-header { border-bottom:1px solid #ccc; margin-bottom:15px; padding-bottom:15px; }
        .test {margin-top: 30px; margin-left: 100px;}
        .task {margin-top: 30px; margin-left: 100px;}
         .tasking {margin-top: 30px; margin-left:50%; text-align:center; padding:10px;}

    </style>
</head>
<body>
<jsp:include page="nav.jsp" flush="true" />
<div class="content">
    <div id="result" class="quiz-body">

                    <form action="${pageContext.request.contextPath}/add-task" method="POST" class="tasking">
                       <h2>ЗАДАЧА</h2>
                        <input type="text" id="name" name="name">
                       <input type="text" class="form-control" id="task" name="task" placeholder="Задача">
                       <input type="text" class="form-control" id="answer" name="answer" placeholder="Задача">
                       <button type="submit" class="btn btn-primary btn-block">Добавить</button>
                    </form>
    </div>
</div>
</body>
</html>
