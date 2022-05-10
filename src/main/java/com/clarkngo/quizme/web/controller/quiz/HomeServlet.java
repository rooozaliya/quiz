//ПРОСТО ПОКАЗЫВАЕТ СПИСОК ТЕСТОВ

package com.clarkngo.quizme.web.controller.quiz;

import com.clarkngo.quizme.web.dao.quiz.QuizTypeDao;
import com.clarkngo.quizme.web.dao.UserDao;
import com.clarkngo.quizme.web.domain.quiz.QuizType;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        HttpSession oldSession = req.getSession(false);
        String username = (String)oldSession.getAttribute("username");
        UserDao qq = new UserDao();
        String name = qq.oneUser1(username).getName();
        oldSession.setAttribute("name", name);



        QuizTypeDao dao = new QuizTypeDao();
        List<QuizType> qtList = dao.getQuizTypes();
        session.setAttribute("quizTypeList", qtList);
        req.getRequestDispatcher("/home-page").forward(req, res);

    }
}
