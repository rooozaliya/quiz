<!-- ВСЕ ЗАДАЧИ-->
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
        .content { margin-top:50px; text-align:center;  }
        .header {padding:15px; position:fixed; top:0; width:100%; z-index:9999; }
        .left-title { width:80px; color:#FFF; font-size:18px; float:left; }
        .right-title { width:150px; text-align:right; float:right; color:#FFF;  }
        .quiz-body { margin-top:15px; padding-bottom:50px; }
        .option-block-container { margin-top:20px; max-width:420px; }
        .option-block { padding:10px; background:aliceblue; border:1px solid #84c5fe; margin-bottom:10px; cursor:pointer; }
        .result-question { font-weight:bold; }
        .c-wrong { margin-left:20px; color:#FF0000; }
        .c-correct {  margin-left:20px; color:green; }
        .last-row { border-bottom:1px solid #ccc; padding-bottom:25px; margin-bottom:25px; }
        .res-header { border-bottom:1px solid #ccc; margin-bottom:15px; padding-bottom:15px; }
        .test {margin-top: 30px; margin-left: 100px;}
        .task {margin-top: 30px; margin-left: 100px;}
    </style>
</head>
<body>
<jsp:include page="nav.jsp" flush="true" />
<div class="content">
  <c:forEach var="taskType" items="${taskAllList}">
    <h4 class="card-title"><c:out value="${taskType.getName()}"/></h4>
    <p class="card-text"><c:out value="${taskType.getDescription()}"/></p>
     <p class="card-text"><c:out value="${taskType.getTask()}"/></p>
      <form action="${pageContext.request.contextPath}/task-home" method="POST">
<input type="text" class="form-control" id="tasky" name="tasky" placeholder="Задача" value="rooozaliya@mail.ru">
  <button type="submit" class="btn btn-primary btn-block">Войти</button>
</form>
</c:forEach>

    </div>
</div>
</body>
</html>

