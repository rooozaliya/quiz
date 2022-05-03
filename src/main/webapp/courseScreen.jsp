<!-- ЭТО СТРАНИЦА ОТОБРАЖЕНИЯ ВОПРОСОВ -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.clarkngo.quizme.web.domain.CourseType" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page buffer="none" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .content { margin-top:54px; }
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
                </div>
            </div> <!-- End of col-sm-12 -->

        </div> <!-- End of row -->
    </div> <!-- ENd of container fluid -->
</div> <!-- End of content -->

</body>
</html>
