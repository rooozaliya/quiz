package com.clarkngo.quizme.web.controller.logreg;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession oldSession = req.getSession(false);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        if (oldSession != null) {
            oldSession.invalidate();
        }

        req.getRequestDispatcher("/loginForm.jsp").forward(req,res);
//        этот сервлет перенаправляет нас на страничку входа.
    }
}
