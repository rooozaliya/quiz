<!-- ЭТО СТРАНИЦА ОТОБРАЖЕНИЯ ВОПРОСОВ -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.clarkngo.quizme.web.domain.course.CourseType" %>
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
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-12">
                <div id="result" class="quiz-body">
                    <h2>  ТЕОРИЯ</h2>

                        <p><c:out value="${listTheories}"/></p>
                        <iframe width="880" height="495" src="https://www.youtube.com/embed/1ex_bNIFR1A" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                </div>

            </div>
        </div>
         <h2>Проверь свои знания. Пройди тест.</h2>
        <div class="test">


           <c:forEach var="quizType" items="${quizTypeList}">

                          <div class="col-sm-4">
                              <div class="card border-primary mb-3" style="max-width: 25rem;">


                                  <img class="card-img-top" src="${pageContext.request.contextPath}/resourses/img/test/course${courseTypeId}/${quizType.getQuizTypeId()}.png" alt="Carddd" width="200px" height="100px">

                                  <div class="card-body">

                                      <h4 class="card-title"><c:out value="${quizType.getName()}"/></h4>
                                      <p class="card-text"><c:out value="${quizType.getDescription()}"/></p>

                                      <form action="${pageContext.request.contextPath}/quiz" method="GET">
                                          <div class="form-group">
                                              <input type="hidden" class="form-control" name="quizTypeId" value="${quizType.getQuizTypeId()}">
                                          </div>
                                          <div class="form-group">
                                              <input type="hidden" class="form-control" name="page" value="1">
                                          </div>



                                    <c:choose>
                                        <c:when test="${(sumBall>10 and (sumBall<20 and quizType.getQuizTypeId()<=2))  or quizType.getQuizTypeId()==1}">
                                           <button type="submit" class="btn btn-primary btn-block">Приступить к тестированию</button>
                                        </c:when>
                                        <c:when test="${sumBall<=10  and (quizType.getQuizTypeId()==2  or quizType.getQuizTypeId()==3)}">
                                            <p>Нужно больше баллов</p>
                                         </c:when>
                                          <c:when test="${sumBall>=20}">
                                               <button type="submit" class="btn btn-primary btn-block">Приступить к тестированию</button>
                                          </c:when>
                                          <c:otherwise>
                                          <p>Нужно больше баллов</p>
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
                                                       <c:when test="${sumBall<10 or  taskType.getTaskTypeId()==1}">
                                                          <button type="submit" class="btn btn-primary btn-block">Приступить к задаче</button>
                                                       </c:when>
                                                       <c:when test="${(sumBall>=10  and sumBall<=20) and taskType.getTaskTypeId()==2 }">
                                                          <button type="submit" class="btn btn-primary btn-block">Приступить к задаче</button>
                                                       </c:when>
                                                       <c:when test="${sumBall>=20}">
                                                          <button type="submit" class="btn btn-primary btn-block">Приступить к задаче</button>
                                                       </c:when>
                                                       <c:otherwise>
                                                          <p>Нужно больше баллов</p>
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
