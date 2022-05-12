//ПОМОГАЕТ ПОКАЗАТЬ ВОПРОСЫ
package com.clarkngo.quizme.web.controller.quiz;

import com.clarkngo.quizme.web.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "QuizScreenServlet", value = "/quiz-screen")
public class QuizScreenServlet extends HttpServlet {

    private UserDao userDao;

    public void init() {this.userDao = new UserDao();}


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        String q = req.getParameter("quizTypeId");
        req.setAttribute("quizTypeId", q);
        req.getRequestDispatcher("/quizScreen.jsp").forward(req,res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        String result = req.getParameter("scr");
        System.out.println("Результат тестирования: "+result);
        String a = req.getParameter("quizTypeId");
        System.out.println("Номер теста: "+a);
        int num = Integer.parseInt(a);

        HttpSession oldSession = req.getSession(false);
        String username = (String)oldSession.getAttribute("username");
        userDao.addResult( username, result, num);


        res.setContentType("text/html");
        req.getRequestDispatcher("/quizScreen.jsp").include(req,res);

    }
}
