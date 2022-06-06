<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.clarkngo.quizme.web.domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>




<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Список пользователей</title>


</head>
<style>
 * {
                              box-sizing: border-box;
                            }

                            body {
                              font-family: Arial;

                              padding: 20px;
                            }

                            .heading {
                              font-size: 25px;
                              margin-right: 25px;
                            }

                            .fa {
                              font-size: 25px;
                            }

                            .checked {
                              color: orange;
                            }

                            /* Три колонки макет */
                            .side {
                              float: left;
                              width: 15%;
                              margin-top:10px;
                            }

                            .middle {
                              margin-top:10px;
                              float: left;
                              width: 70%;
                            }

                            /* Поместите текст справа */
                            .right {
                              text-align: right;
                            }
                            .row{
                            max-width:800px;
                            margin:0 auto;}

                            /* Очистить поплавки после столбцов */
                            .row:after {
                              content: "";
                              display: table;
                              clear: both;
                            }

                            /* Бар контейнер */
                            .bar-container {
                              width: 100%;
                              background-color: #f1f1f1;
                              text-align: center;
                              color: white;
                            }

                            /* Индивидуальный бары */
                            .bar-0 {width: 100%; height: 18px; background-color: #2Cbc56;}
                            .bar-1 {width: 90%; height: 18px; background-color: #4CAF50;}
                            .bar-2 {width: 80%; height: 18px; background-color: #2196F3;}
                            .bar-3 {width: 70%; height: 18px; background-color: #00bcd4;}
                            .bar-4 {width: 60%; height: 18px; background-color: #ff9800;}
                            .bar-5 {width: 50%; height: 18px; background-color: #f44336;}
                            .bar-6 {width: 40%; height: 18px; background-color: #f44336;}
                            .bar-7 {width: 30%; height: 18px; background-color: #f44336;}
                            .bar-8 {width: 20%; height: 18px; background-color: #f44336;}
                            .bar-9 {width: 10%; height: 18px; background-color: #f44336;}
                            .bar-10 {width: 5%; height: 18px; background-color: #f44336;}


                            @media (max-width: 400px) {
                              .side, .middle {
                                width: 100%;
                              }
                              .right {
                                display: none;
                              }
                            }
</style>
<body>
<jsp:include page="nav.jsp" flush="true" />
                            <h1>Лидеры в обучении</h1>
                            <c:set var="startIndex" value="0"/>
                            <c:set var="endIndex"  value="7"/>
                            <c:forEach  begin="${startIndex}" end="${endIndex}" step="1" var="index">
                                 <div class="row">
                                        <div class="side">
                                            <div><c:out value="${listUsers[index].getName()}" /></div>
                                          </div>
                                          <div class="middle">
                                            <div class="bar-container">
                                              <div class="bar-${index}"></div>
                                            </div>
                                          </div>
                                          <div class="side right">
                                            <div><c:out value="${listUsers[index].getResult()}"/></div>
                                          </div>
                                       </div>
                                 </div>
                            </c:forEach>
                             <hr style="border:3px solid #f1f1f1">

                    <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                  <thead>
                                                    <th>Почта</th>
                                                    <th>Тест 1</th>
                                                    <th>Тест 2</th>
                                                    <th>Тест 3</th>
                                                    <th>Итого</th>
                                  </thead>
                                                    <c:forEach items="${listUser}" var="user">
                                                      <tr>
                                                        <td><c:out value="${user.getName()}"/></td>
                                                        <td><c:out value="${user.getResult1()}"/></td>
                                                        <td><c:out value="${user.getResult2()}"/></td>
                                                        <td><c:out value="${user.getResult3()}"/></td>
                                                        <td id="allRes"><c:out value="${user.getResult()}"/></td>
                                                      </tr>
                                                    </c:forEach>

                                </table>
                            </div>





                              <!--
                                 \\\\\\\\\\\\\\\\\\\\\\\\\\\\
                            <div class="row">
                              <div class="side">
                                <div><c:out value="${listUser[0].getName()}"/></div>
                              </div>
                              <div class="middle">
                                <div class="bar-container">
                                  <div class="bar-5"></div>
                                </div>
                              </div>
                              <div class="side right">
                                <div><c:out value="${listUser[0].getResult()}"/></div>
                              </div>
                              <div class="side">
                                <div><c:out value="${listUser[1].getName()}"/></div>
                              </div>
                              <div class="middle">
                                <div class="bar-container">
                                  <div class="bar-4"></div>
                                </div>
                              </div>
                              <div class="side right">
                                <div><c:out value="${listUser[1].getResult()}"/></div>
                              </div>
                              <div class="side">
                                <div></div>
                              </div>
                              <div class="middle">
                                <div class="bar-container">
                                  <div class="bar-3"></div>
                                </div>
                              </div>
                              <div class="side right">
                                <div>15</div>
                              </div>
                              <div class="side">
                                <div></div>
                              </div>
                              <div class="middle">
                                <div class="bar-container">
                                  <div class="bar-2"></div>
                                </div>
                              </div>
                              <div class="side right">
                                <div>6</div>
                              </div>
                              <div class="side">
                                <div></div>
                              </div>
                              <div class="middle">
                                <div class="bar-container">
                                  <div class="bar-1"></div>
                                </div>
                              </div>
                              <div class="side right">
                                <div>20</div>
                              </div>
                            </div>
-->


                            </body>

                            </html>


