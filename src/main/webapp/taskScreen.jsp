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
        .quiz-body { margin-top:15px; padding-bottom:50px; max-width:800px;  padding-left:50px;}
        .option-block-container { margin-top:20px; max-width:420px; }
        .option-block { padding:10px; background:aliceblue; border:1px solid #84c5fe; margin-bottom:10px; cursor:pointer; }
        .result-question { font-weight:bold; }
        .c-wrong { margin-left:20px; color:#FF0000; }
        .c-correct {  margin-left:20px; color:green; }
        .last-row { border-bottom:1px solid #ccc; padding-bottom:25px; margin-bottom:25px; }
        .res-header { border-bottom:1px solid #ccc; margin-bottom:15px; padding-bottom:15px; }
        .test {margin-top: 30px; margin-left: 20px;}
        .cont {width:100px;height:100px; }
        .check {width:100px;height:100px; }
         .tasking {margin-top: 30px; margin-left:100px; text-align:center; width:60%;}
         .card-title {margin-top: 30px; margin-left:100px; text-align:center; width:60%;}
    </style>
</head>
<body>
<jsp:include page="nav.jsp" flush="true" />
<div class="content">
    <div id="result" class="quiz-body">
                    <h2>  ЗАДАЧА</h2>
          <!--          <form action="${pageContext.request.contextPath}/task-home" method="POST" class="tasking">
                       <p><c:out value="${task}"/></p>
                       <input type="text" class="form-control" id="tasky" name="tasky" placeholder="Задача" value="saaa">
                       <button type="submit" class="btn btn-primary btn-block">Проверить</button>
                    </form>-->
                      <c:forEach var="taskType" items="${taskAllList}">
                        <h4 class="card-title"><c:out value="${taskType.getTask()}"/></h4>

                        <form action="${pageContext.request.contextPath}/task-home" method="POST" class="tasking">
                           <input type="hidden" class="card-title" style="color:red" id="TaskId" name="TaskId" value="${taskType.getTaskId()}"/>
                           <input type="text" class="form-control" style="color:red" id="tasky" name="tasky" value="${taskType.getAnswer()}" placeholder="Ответ">
                           <button type="submit" class="btn btn-primary btn-block ">Проверить</button>

                        </form>
                      </c:forEach>



    </div>
</div>
</body>
</html>