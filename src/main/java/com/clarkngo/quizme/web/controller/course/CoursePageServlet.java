// ПРОСТО СПИСОК КУРСОВ

package com.clarkngo.quizme.web.controller.course;

import com.clarkngo.quizme.web.dao.quiz.QuizTypeDao;
import com.clarkngo.quizme.web.dao.UserDao;
import com.clarkngo.quizme.web.dao.task.TaskTypeDao;
import com.clarkngo.quizme.web.domain.TaskType;
import com.clarkngo.quizme.web.domain.quiz.QuizType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CoursePageServlet", value = "/course-page")
public class CoursePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        HttpSession oldSession = req.getSession(false);
        String username = (String)oldSession.getAttribute("username");
        UserDao qq = new UserDao();
        String name = qq.oneUser1(username).getName();
        oldSession.setAttribute("name", name);
        if(username == null) {
            String path = req.getContextPath() + "/error";
            response.sendRedirect(path);

        } else {
        req.getRequestDispatcher("/course.jsp").forward(req,response);
        req.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        QuizTypeDao dao = new QuizTypeDao();
        List<QuizType> qtList = dao.getQuizTypes();
        oldSession.setAttribute("quizTypeList", qtList);

        TaskTypeDao dao1 = new TaskTypeDao();
        List<TaskType> qtList1 = dao1.getTaskTypes();
        oldSession.setAttribute("taskTypeList", qtList1);

            req.getRequestDispatcher("/home-page").forward(req, response);
          }
    }
}
