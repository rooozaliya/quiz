package com.clarkngo.quizme.web.controller.logreg;

import com.clarkngo.quizme.web.dao.UserDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {

    private UserDao userDao;

    public void init() {this.userDao = new UserDao();}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");     
        request.getRequestDispatcher("/registerForm.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");


        if(userDao.userExists(username)) {
            res.setContentType("text/html");
            PrintWriter writer = res.getWriter();
            req.getRequestDispatcher("/registerForm.jsp").include(req, res);


            writer.print(
                    "<div class='container'>" +
                            "<h2 style='color: red;'>Пользователь с такой почтой уже существует.</h2>" +
                            "</div>"
            );

            writer.close();

        } else {
            userDao.addUser(name, username, password);
            res.setContentType("text/html");
            PrintWriter writer = res.getWriter();
            req.getRequestDispatcher("/loginForm.jsp").include(req, res);

            writer.print(
                    "<div class='container'>" +
                            "<h2 style='color: green;'>Успешно. Войдите</h2>" +
                            "</div>"
            );

            writer.close();
        }
    }
}
