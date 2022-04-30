//ПОМОГАЕТ ПОКАЗАТЬ КУРСЫ
package com.clarkngo.quizme.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CourseScreenServlet", value = "/course-screen")
public class CourseScreenServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/courseScreen.jsp").forward(req,res);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
    }
}
