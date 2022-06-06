//ПОМОГАЕТ ПЕРЕНАПРАВИТЬ НА СТРАНИЦУ ВОПРОСОВ

package com.clarkngo.quizme.web.controller.quiz;

import com.clarkngo.quizme.web.dao.quiz.QuizDao;
import com.clarkngo.quizme.web.domain.quiz.Quiz;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "QuizServlet", value = "/quiz")
public class QuizServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        if (session.getAttribute("quiz") == null) {
            int id = Integer.parseInt(req.getParameter("quizTypeId"));
            QuizDao dao = new QuizDao();
            Quiz quiz = dao.getQuiz(id);
            session.setAttribute("quiz", quiz);
            session.setAttribute("page",1);
        } else {
            session.setAttribute("page", req.getParameter("page"));
            session.setAttribute("questionId", req.getParameter("questionId"));
        }
        req.getRequestDispatcher("/quiz-screen").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/quizScreen.jsp").forward(req,res);


    }
}
