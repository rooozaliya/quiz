<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.clarkngo.quizme.web.domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


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

<body>
<jsp:include page="nav.jsp" flush="true" />

<div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">

                                  <thead>

                                                    <th>Почта</th>

                                                    <th>Тест 1</th>
                                                    <th>Тест 2</th>
                                                    <th>Тест 3</th>
                                                    <th>Result</th>
                                  </thead>
                                                    <c:forEach items="${listUser}" var="user">
                                                      <tr>

                                                        <td><c:out value="${user.getEmail()}"/></td>
                                                        <td ><c:out value="${user.getResult1()}"/></td>
                                                        <td><c:out value="${user.getResult2()}"/></td>
                                                        <td><c:out value="${user.getResult3()}"/></td>


                                                      </tr>
                                                    </c:forEach>

                                </table>
                            </div>

                            </body>

                            </html>