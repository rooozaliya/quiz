
//ВНУТРЕННОСТЬ ЗАДАЧИ

package com.clarkngo.quizme.web.controller.task;
import com.clarkngo.quizme.web.dao.UserDao;
import com.clarkngo.quizme.web.dao.course.CourseTypeDao;
import com.clarkngo.quizme.web.dao.task.TaskDao;
import com.clarkngo.quizme.web.dao.task.TaskTypeDao;
import com.clarkngo.quizme.web.domain.course.CourseType;
import com.clarkngo.quizme.web.domain.task.Task;
import com.clarkngo.quizme.web.domain.task.TaskType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TaskServlet", value = "/task-home")
public class TaskServlet extends HttpServlet {
    private TaskDao taskDao;

    public void init() {
        this.taskDao = new TaskDao();
    }

    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        String tasky = req.getParameter("tasky");
        System.out.println(tasky);

        if (session.getAttribute("task-home") == null) {
            session.setAttribute("page",1);
            int id = Integer.parseInt(req.getParameter("taskTypeId"));
            TaskTypeDao dao = new TaskTypeDao();
            TaskType course = dao.getTaskType(id);
            String task= course.getTask();
            session.setAttribute("task", task);
            session.setAttribute("taskTypeId", id);
        } else {
            session.setAttribute("page", req.getParameter("page"));
            session.setAttribute("questionId", req.getParameter("questionId"));
        }
        req.getRequestDispatcher("/task-screen").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        String tasky = req.getParameter("tasky");
        int id = (int) session.getAttribute("taskTypeId");
        PrintWriter writer = res.getWriter();
        res.setContentType("text/html");

        req.getRequestDispatcher("/taskScreen.jsp").include(req, res);

        if(taskDao.checkAnswer(id, tasky)){
            writer.println(
                    "<div class='container'>" +
                            "<h2> Верно</h2>" +
                            "</div>"
            );

            writer.close();
        }
        else{
            writer.println(
                    "<div class='container'>" +
                            "<h2> Мимо</h2>" +
                            "</div>"
            );

            writer.close();
        }

        writer.println(
                "<div class='container'>" +
                        "<h2>Задача проверена</h2>" +
                        "</div>"
        );

        writer.close();

       // req.getRequestDispatcher("/taskScreen.jsp").forward(req,res);


    }
}