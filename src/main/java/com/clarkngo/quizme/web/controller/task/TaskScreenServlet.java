//ВНУТРЕННОСТЬ ЗАДАЧ
package com.clarkngo.quizme.web.controller.task;

import com.clarkngo.quizme.web.dao.UserDao;
import com.clarkngo.quizme.web.dao.course.CourseTypeDao;
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
import java.util.List;

@WebServlet(name = "TaskScreenServlet", value = "/task-screen")
public class TaskScreenServlet extends HttpServlet {

    private UserDao userDao;

    public void init() {this.userDao = new UserDao();}


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/taskScreen.jsp").forward(req,res);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(true);
        int id = Integer.parseInt(req.getParameter("taskTypeId"));
        TaskTypeDao dao = new TaskTypeDao();
        TaskType task = dao.getTaskType(id);
        String taskA= task.getTask();
        List<TaskType> qtList1 = dao.getAllTask(id);
        session.setAttribute("taskAllList", qtList1);
        session.setAttribute("task", taskA);
        session.setAttribute("taskTypeId", id);
        req.getRequestDispatcher("/taskScreen.jsp").forward(req,res);
    }

  //  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        res.setCharacterEncoding("UTF-8");
////        String a = req.getParameter("taskTypeId");
////        System.out.println("Номер теста: "+a);
////        int num = Integer.parseInt(a);
//        HttpSession oldSession = req.getSession(false);
//        String username = (String)oldSession.getAttribute("username");
//        res.setContentType("text/html");
//        req.getRequestDispatcher("/taskScreen.jsp").include(req,res);

 //   }
}
