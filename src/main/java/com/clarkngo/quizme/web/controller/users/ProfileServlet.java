package com.clarkngo.quizme.web.controller.users;

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
        int ball = qq.allResult(username).getResult();
        String password = (String)oldSession.getAttribute("password");
        oldSession.setAttribute("username", username);
        oldSession.setAttribute("password", password);
        oldSession.setAttribute("name", name);
        oldSession.setAttribute("ball", ball);
        if(username == null) {
            String path = req.getContextPath() + "/error";
            resp.sendRedirect(path);
        } else {
            req.getRequestDispatcher("/userProfile.jsp").include(req, resp);
        }
        writer.close();
    }
}
