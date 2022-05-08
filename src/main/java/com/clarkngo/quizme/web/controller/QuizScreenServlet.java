//ПОМОГАЕТ ПОКАЗАТЬ ВОПРОСЫ
package com.clarkngo.quizme.web.controller;

import com.clarkngo.quizme.web.dao.QuizTypeDao;
import com.clarkngo.quizme.web.dao.UserDao;
import com.clarkngo.quizme.web.domain.QuizType;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "QuizScreenServlet", value = "/quiz-screen")
public class QuizScreenServlet extends HttpServlet {

    private UserDao userDao;

    public void init() {this.userDao = new UserDao();}


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");


        req.getRequestDispatcher("/quizScreen.jsp").forward(req,res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String result = req.getParameter("scr");
        System.out.println(result+" нихуя себе");
        HttpSession oldSession = req.getSession(false);
        String username = (String)oldSession.getAttribute("username");
        req.getRequestDispatcher("/quizScreen.jsp").forward(req,res);
        userDao.addResult( username, result);
        res.setContentType("text/html");
        req.getRequestDispatcher("/course").include(req,res);

    }
}
