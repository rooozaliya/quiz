//ПРОСТО СПИСОК ЗАДАЧ

package com.clarkngo.quizme.web.controller.task;

import com.clarkngo.quizme.web.dao.UserDao;
import com.clarkngo.quizme.web.dao.task.TaskTypeDao;
import com.clarkngo.quizme.web.domain.task.TaskType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "TaskHomeServlet", value = "/task")
public class TaskHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        HttpSession oldSession = req.getSession(false);
        String username = (String)oldSession.getAttribute("username");
        UserDao qq = new UserDao();
        int ball = qq.allResult(username).getResult();
        oldSession.setAttribute("ball", ball);
        req.getRequestDispatcher("/task.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.sendRedirect(req.getContextPath() + "/task");
    }
}
