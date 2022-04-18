package com.clarkngo.quizme.web.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "AdminServlet", value = "/admin")
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        HttpSession oldSession = req.getSession(false);
        PrintWriter writer = res.getWriter();
        req.getRequestDispatcher("/admin.jsp").include(req, res);
        if (oldSession == null) {

            writer.print(
                    "<h1>Авторизуйся</h1>"
            );
            writer.close();
        }
        else {
            String username = (String) oldSession.getAttribute("username");
            if (username.equals("rooozaliya@mail.ru")) {
                writer.print(
                        "<h1>Админ</h1>"
                );
                writer.close();
            } else if (oldSession != null) {
                writer.print(
                        "<h1>Не админ</h1>"
                );
                writer.close();
            }
        }
    }
}




