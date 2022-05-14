package com.clarkngo.quizme.web.controller;

import com.clarkngo.quizme.web.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private UserDao userDao;

    public void init() {
        this.userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");

        if (username!=null && password!=null && userDao.checkCredentials(username, password)) {
            HttpSession oldSession = req.getSession(false);
            if (oldSession != null) {
                oldSession.invalidate();
            }

            HttpSession newSession = req.getSession(true);
            newSession.setAttribute("username", username);
            newSession.setAttribute("password", password);
            newSession.setAttribute("name", name);
            newSession.setMaxInactiveInterval(100 * 60);
            res.sendRedirect(req.getContextPath() + "/course");
        } else {
            res.setContentType("text/html");
            PrintWriter writer = res.getWriter();
            req.getRequestDispatcher("/loginForm.jsp").include(req, res);

            writer.println(
                    "<div class='container'>" +
                            "<h2 style='color: red;'>Incorrect user name or password.</h2>" +
                            "</div>"
            );

            writer.close();
        }
    }
}
