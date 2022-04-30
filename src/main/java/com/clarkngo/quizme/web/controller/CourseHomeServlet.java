package com.clarkngo.quizme.web.controller;

import com.clarkngo.quizme.web.dao.CourseTypeDao;
import com.clarkngo.quizme.web.dao.QuizTypeDao;
import com.clarkngo.quizme.web.domain.CourseType;
import com.clarkngo.quizme.web.domain.QuizType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CourseHomeServlet", value = "/course")
public class CourseHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");

        CourseTypeDao dao = new CourseTypeDao();
        List<CourseType> qtList = dao.getCourseTypes();
        session.setAttribute("courseTypeList", qtList);
        req.getRequestDispatcher("/course-page").forward(req, res);
    }
}
