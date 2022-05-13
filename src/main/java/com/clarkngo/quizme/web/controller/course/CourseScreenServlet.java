// ВНУТРЕННОСТЬ КУРСОВ
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

@WebServlet(name = "CourseScreenServlet", value = "/course-screen")
public class CourseScreenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/courseScreen.jsp").forward(req,res);
        HttpSession session = req.getSession(true);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("courseTypeId"));
        CourseTypeDao dao = new CourseTypeDao();
        CourseType course = dao.getCourseType(id);
        String descrTheory= course.getTheory();
        session.setAttribute("listTheories", descrTheory);
        session.setAttribute("courseTypeId", id);
        req.getRequestDispatcher("/courseScreen.jsp").forward(req, res);
    }
}