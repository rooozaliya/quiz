
package com.clarkngo.quizme.web.controller.add;

import com.clarkngo.quizme.web.dao.UserDao;
import com.clarkngo.quizme.web.dao.course.CourseTypeDao;
import com.clarkngo.quizme.web.dao.task.TaskDao;
import com.clarkngo.quizme.web.dao.task.TaskTypeDao;
import com.clarkngo.quizme.web.domain.course.CourseType;
import com.clarkngo.quizme.web.domain.task.TaskType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AddTheoryServlet", value = "/add-theory")
public class AddTheoryServlet extends HttpServlet {

    private TaskDao taskDao;

    public void init() {
        this.taskDao = new TaskDao();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/addNewTask.jsp").forward(req, res);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/addNewTask.jsp").forward(req, res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String theory = req.getParameter("theory");
        String description = req.getParameter("description");
        String link = req.getParameter("link");
        taskDao.addTheory(name, description, theory, link);
        res.setContentType("text/html");
        req.getRequestDispatcher("/addNewTask.jsp").include(req, res);

    }
}
