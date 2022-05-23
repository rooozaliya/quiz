package com.clarkngo.quizme.web.controller.logreg;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/error")
public class ErrorServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("Error.jsp");
        PrintWriter writer = response.getWriter();
        request.getRequestDispatcher("/Error.jsp").include(request, response);
//        try {
//         //   writer.println("<h2> Невозможно получить данные, возможно вы не авторизованы.</h2>");
//        } finally {
//            writer.close();
//        }
    }
}