package com.clarkngo.quizme.web.controller.quiz;

import com.clarkngo.quizme.web.dao.question.QuestionDao;
import com.clarkngo.quizme.web.domain.Question;
import com.clarkngo.quizme.web.util.JsonConverter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "GetQuizServlet", value = "/quizjson")
public class GetQuizServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("quizTypeId"));
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        List<Question> quiz = new QuestionDao().getTenRandomQuestions(id);
        JsonConverter converter = new JsonConverter();
        String output = converter.convertToJson(quiz);
        PrintWriter out = response.getWriter();
        out.print(output);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/quizScreen.jsp").forward(request,response);
    }
}
