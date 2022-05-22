<!-- ВСЕ ЗАДАЧИ ВРОДЕ НЕНУЖНО-->
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
        .gray{color:green;}
    </style>
</head>
<body>
<jsp:include page="nav.jsp" flush="true" />
<div class="content">
 <h2>Реши задачи.</h2>
                <div class="task">
                   <c:forEach var="taskType" items="${taskTypeList}">
                                  <div class="col-sm-4">
                                      <div class="card border-primary mb-3" style="max-width: 25rem;">
                                          <img class="card-img-top" src="${pageContext.request.contextPath}/resourses/img/course/task.jpg" alt="Carddd" width="200px" height="150px">
                                          <div class="card-body">
                                              <h4 class="card-title"><c:out value="${taskType.getName()}"/></h4>
                                              <p class="card-text"><c:out value="${taskType.getDescription()}"/></p>
                                              <form action="${pageContext.request.contextPath}/task-home" method="GET">
                                                  <div class="form-group">
                                                      <input type="hidden" class="form-control" name="taskTypeId" value="${taskType.getTaskTypeId()}">
                                                  </div>
                                                  <div class="form-group">
                                                      <input type="hidden" class="form-control" name="page" value="1">
                                                  </div>
                                                    <c:choose>
                                                       <c:when test="${ball<10 and  taskType.getTaskTypeId()==1}">
                                                          <button type="submit" class="btn btn-primary btn-block">Приступить к задаче</button>
                                                       </c:when>
                                                       <c:when test="${(ball>10 and ball<=20) and (taskType.getTaskTypeId()==2 or taskType.getTaskTypeId()==1) }">
                                                          <button type="submit" class="btn btn-primary btn-block">Приступить к задаче</button>
                                                       </c:when>
                                                       <c:when test="${ball>=20 and taskType.getTaskTypeId()>=1 }">
                                                          <button type="submit" class="btn btn-primary btn-block">Приступить к задаче</button>
                                                       </c:when>
                                                       <c:otherwise>
                                                          <button class="btn  gray">Нужно больше баллов</button>
                                                       </c:otherwise>
                                                    </c:choose>


                                                <div class="form-group">
                                                </div>
                                              </form>
                                          </div>
                                      </div>
                                  </div>
                              </c:forEach>
                </div>





    </div>
</div>
</body>
</html>

