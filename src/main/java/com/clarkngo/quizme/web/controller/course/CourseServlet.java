// ВНУТРЕННОСТЬ КУРСА

package com.clarkngo.quizme.web.controller.course;

import com.clarkngo.quizme.web.dao.course.CourseTypeDao;
import com.clarkngo.quizme.web.domain.course.CourseType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CourseServlet", value = "/course-home")
public class CourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        if (session.getAttribute("course-home") == null) {
            session.setAttribute("page",1);
            int id = Integer.parseInt(req.getParameter("courseTypeId"));
            CourseTypeDao dao = new CourseTypeDao();
            CourseType course = dao.getCourseType(id);
            String descrTheory= course.getTheory();
            String link= course.getLink();
            session.setAttribute("listTheories", descrTheory);
            session.setAttribute("courseTypeId", id);
            session.setAttribute("link", link);
        } else {
            session.setAttribute("page", req.getParameter("page"));
            session.setAttribute("questionId", req.getParameter("questionId"));
        }
        req.getRequestDispatcher("/course-screen").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.sendRedirect(req.getContextPath() + "/course-screen");
    }
}
