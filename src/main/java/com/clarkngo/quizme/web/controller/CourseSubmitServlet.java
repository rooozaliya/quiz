//НЕПОНЯТНО ДЛЯ ЧЕГО НУЖНО

package com.clarkngo.quizme.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CourseSubmitServlet", value = "/courseSubmit")
public class CourseSubmitServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");

        System.out.println(req.getParameter("total"));
    }
}
