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
        HttpSession session = req.getSession(true);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");

        TaskTypeDao dao = new TaskTypeDao();
        List<TaskType> qtList = dao.getTaskTypes();
        HttpSession oldSession = req.getSession(false);
        String username = (String)oldSession.getAttribute("username");
        UserDao qq = new UserDao();
        int ball = qq.allResult(username).getResult();
        oldSession.setAttribute("ball", ball);

//        CourseType course = dao.getCourseType(2);
//        session.setAttribute("courseType", course);
        //session.setAttribute("taskTypeList", qtList);
        req.getRequestDispatcher("/task.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String tasky = req.getParameter("tasky");
        System.out.println(tasky);
        System.out.println(req.getParameter("courseTypeId")+"str36");
        System.out.println(req.getParameter("page")+"str37");
        System.out.println(req.getParameter("questionId")+"str38");


    }
}
