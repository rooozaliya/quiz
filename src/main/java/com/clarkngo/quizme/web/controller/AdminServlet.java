package com.clarkngo.quizme.web.controller;

import com.clarkngo.quizme.web.dao.QuizTypeDao;
import com.clarkngo.quizme.web.dao.UserDao;
import com.clarkngo.quizme.web.domain.QuizType;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/admin")
public class AdminServlet extends HttpServlet {

//    private UserDao userDao;
//
//    public void init() {
//        this.userDao = new UserDao();
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("/admin.jsp").forward(request, response);
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      //  String username = req.getParameter("username");
        res.setContentType("text/html");
        HttpSession oldSession = req.getSession(false);
        String username = (String)oldSession.getAttribute("username");

            PrintWriter writer = res.getWriter();
            if (username.equals("rooozaliya@mail.ru")) {
                writer.println(
                "<h1>ROOOOOOOOOO</h1>"
                           );
                writer.close();
                System.out.println("kcdkckd");
            }
            else{
                writer.println(
                "<h1>))))</h1>"
                );

            writer.close();
           System.out.println("kcdkccsfheihfiafjokd" + username);}



        }
    }




