package com.clarkngo.quizme.web.controller;

import com.clarkngo.quizme.web.dao.CourseDao;
import com.clarkngo.quizme.web.dao.QuizDao;
import com.clarkngo.quizme.web.domain.Course;
import com.clarkngo.quizme.web.domain.Quiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CourseServlet", value = "/course")
public class CourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");

       // res.setHeader("Set-Cookie","JSESSIONID=" + session.getId());
        if (session.getAttribute("quiz") == null) {
            int id = Integer.parseInt(req.getParameter("courseTypeId"));
            int page = Integer.parseInt(req.getParameter("page"));
            CourseDao dao = new CourseDao();
            Course course = dao.getCourse(id);
            session.setAttribute("course", course);
            session.setAttribute("page",1);
        } else {
            session.setAttribute("page", req.getParameter("page"));
            session.setAttribute("questionId", req.getParameter("questionId"));
            System.out.println(req.getParameter("questionId"));
        }
        req.getRequestDispatcher("/course-screen").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        System.out.println(req.getParameter("courseTypeId"));
        System.out.println(req.getParameter("page"));
        System.out.println(req.getParameter("questionId"));

    }
}
