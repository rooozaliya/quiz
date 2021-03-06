<!-- ВСЕ КУРСЫ-->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.clarkngo.quizme.web.domain.course.CourseType" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Курсы</title>
</head>
<jsp:include page="nav.jsp" flush="true"  />
<body>
    <div class="container">
        <div class="row">
            <c:forEach var="courseType" items="${courseTypeList}">
                <div class="col-sm-4">
                    <div class="card border-primary mb-3" style="max-width: 25rem;">
                     <img class="card-img-top" src="${pageContext.request.contextPath}/resourses/img/course/course1/1.png" alt="Carddd" width="255px" height="150px">

                        <div class="card-body">
                            <h4 class="card-title"><c:out value="${courseType.getName()}"/></h4>

                            <form action="${pageContext.request.contextPath}/course-home" method="GET">
                                <div class="form-group">
                                    <input type="hidden" class="form-control" name="courseTypeId" value="${courseType.getCourseTypeId()}">
                                </div>
                                <div class="form-group">
                                    <input type="hidden" class="form-control" name="page" value="1">
                                </div>
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary btn-block">Приступить к изучению материала</button>
                                </div>
                            </form>
                        </div>

                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</body>
</html>
