<!-- ЭТО СТРАНИЦА ОТОБРАЖЕНИЯ ВОПРОСОВ -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.clarkngo.quizme.web.domain.QuizType" %>
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

<header class="header bg-primary">

    <div class="left-title">JS Quiz</div>
    <div class="right-title">Total Questions: <span id="tque"></span></div>
    <div class="clearfix"></div>
</header>
<div class="content">
    <div class="container-fluid">

        <div class="row">
            <div class="col-sm-12">
                <div id="result" class="quiz-body">

                    <form id="sampleForm" name="sampleForm" action="http://localhost:8080/app/quizSubmit" method="POST">

                        <fieldset class="form-group">

                            <button  name="previous" id="previous" class="btn btn-success">Предыдущий</button>
                            &nbsp;
                            <button  name="next" id="next" class="btn btn-success">Следующий</button>
                            <h4><span id="qid">1.</span> <span id="question"></span></h4>

                            <div class="option-block-container" id="question-options">

                            </div> <!-- End of option block -->
                        </fieldset>

                    </form>
                </div>
            </div> <!-- End of col-sm-12 -->

        </div> <!-- End of row -->
    </div> <!-- ENd of container fluid -->
</div> <!-- End of content -->

</body>
</html>
