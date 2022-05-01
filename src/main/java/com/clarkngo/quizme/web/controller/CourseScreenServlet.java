//ПОМОГАЕТ ПОКАЗАТЬ КУРСЫ
package com.clarkngo.quizme.web.controller;

import com.clarkngo.quizme.web.dao.ChatDao;
import com.clarkngo.quizme.web.dao.CourseDao;
import com.clarkngo.quizme.web.dao.CourseTypeDao;
import com.clarkngo.quizme.web.domain.Chat;
import com.clarkngo.quizme.web.domain.Course;
import com.clarkngo.quizme.web.domain.CourseType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CourseScreenServlet", value = "/course-screen")
public class CourseScreenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/courseScreen.jsp").forward(req,res);
        HttpSession session = req.getSession(true);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");

        CourseTypeDao dao = new CourseTypeDao();
        List<CourseType> listTheory = dao.getCourseTypes();
        session.setAttribute("listTheories", listTheory);
        req.getRequestDispatcher("/courseScreen.jsp").forward(req, res);
    }
}
