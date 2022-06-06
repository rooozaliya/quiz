package com.clarkngo.quizme.web.controller.users;

import com.clarkngo.quizme.web.config.MySqlDS;
import com.clarkngo.quizme.web.dao.UserDao;
import com.clarkngo.quizme.web.domain.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



@WebServlet(name = "AdminServlet", value = "/admin-form")
public class AdminServlet extends HttpServlet {


    private UserDao userDao;

    public void init() {this.userDao = new UserDao();}
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        HttpSession oldSession = req.getSession(false);
        UserDao dao = new UserDao();
        List<User> listUser1 = dao.listAllUsers();
        if (oldSession == null) {
            res.sendRedirect("/error");
        } else {
            String username = (String) oldSession.getAttribute("username");
            if (username.equals("s@s.com")) {
                session.setAttribute("listUser", listUser1);

            } else if (oldSession != null) {
                String path = "{pageContext.request.contextPath}/error";
                res.sendRedirect(path);
            }
        }
        req.getRequestDispatcher("/admin.jsp").forward(req, res);



    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html");
        res.sendRedirect(req.getContextPath() + "/admin-form");
    }
}






