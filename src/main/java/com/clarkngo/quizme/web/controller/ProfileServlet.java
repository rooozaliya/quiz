package com.clarkngo.quizme.web.controller;

import com.clarkngo.quizme.web.dao.UserDao;
import com.clarkngo.quizme.web.domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProfileServlet", value = "/profile")
public class ProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        HttpSession oldSession = req.getSession(false);
        String username = (String)oldSession.getAttribute("username");
        UserDao qq = new UserDao();
       String name = qq.oneUser1(username).getName();
        oldSession.setAttribute("name", name);
        int res = qq.result(username).getResultId();
        oldSession.setAttribute("res", res);
        System.out.println(res);
        String password = (String)oldSession.getAttribute("password");
        if(username == null) {
            String path = req.getContextPath() + "/error";
            resp.sendRedirect(path);
        } else {
            req.getRequestDispatcher("/userProfile.jsp").include(req, resp);
            writer.println(String.format("<h2>Welcome? Username: %s, Password: %s, Name: %s</h2>, N: %s</h2>", username, password, name, res) );
            writer.println(String.format("Session Id: %s", oldSession.getId()));
        }
        writer.close();
    }
}
