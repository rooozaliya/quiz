//ПОМОГАЕТ ПОКАЗАТЬ ВОПРОСЫ
package com.clarkngo.quizme.web.controller.task;

import com.clarkngo.quizme.web.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "TaskScreenServlet", value = "/task-screen")
public class TaskScreenServlet extends HttpServlet {

    private UserDao userDao;

    public void init() {this.userDao = new UserDao();}


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        String q = req.getParameter("taskTypeId");
        System.out.println(q+"==========================");
        req.setAttribute("taskTypeId", q);

       req.getRequestDispatcher("/taskScreen.jsp").forward(req,res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        String a = req.getParameter("taskTypeId");
        System.out.println("Номер теста: "+a);
        int num = Integer.parseInt(a);
        HttpSession oldSession = req.getSession(false);
        String username = (String)oldSession.getAttribute("username");
        res.setContentType("text/html");
        req.getRequestDispatcher("/taskScreen.jsp").include(req,res);

    }
}
