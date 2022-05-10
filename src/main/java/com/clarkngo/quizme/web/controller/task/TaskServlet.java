
//ПОМОГАЕТ ПЕРЕНАПРАВИТЬ НА СТРАНИЦУ ВОПРОСОВ

package com.clarkngo.quizme.web.controller.task;
import com.clarkngo.quizme.web.dao.task.TaskDao;
import com.clarkngo.quizme.web.domain.task.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "TaskServlet", value = "/task-home")
public class TaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        if (session.getAttribute("task") == null) {
            int id = Integer.parseInt(req.getParameter("taskTypeId"));
            int page = Integer.parseInt(req.getParameter("page"));
            TaskDao dao = new TaskDao();
            Task task = dao.getTask(id);
            session.setAttribute("task", task);
            session.setAttribute("page",1);
        } else {
            session.setAttribute("page", req.getParameter("page"));
            session.setAttribute("questionId", req.getParameter("questionId"));
            System.out.println(req.getParameter("questionId"));
        }
        req.getRequestDispatcher("/task-screen").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        System.out.println(req.getParameter("taskTypeId"));
        System.out.println(req.getParameter("page"));
        System.out.println(req.getParameter("questionId"));
        req.getRequestDispatcher("/taskScreen.jsp").forward(req,res);


    }
}
