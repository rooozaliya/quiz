
//ВНУТРЕННОСТЬ ЗАДАЧИ — ГЛАВНАЯ

package com.clarkngo.quizme.web.controller.task;
import com.clarkngo.quizme.web.dao.UserDao;
import com.clarkngo.quizme.web.dao.course.CourseTypeDao;
import com.clarkngo.quizme.web.dao.quiz.QuizDao;
import com.clarkngo.quizme.web.dao.task.TaskDao;
import com.clarkngo.quizme.web.dao.task.TaskTypeDao;
import com.clarkngo.quizme.web.domain.User;
import com.clarkngo.quizme.web.domain.course.CourseType;
import com.clarkngo.quizme.web.domain.quiz.Quiz;
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
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "TaskServlet", value = "/task-home")
public class TaskServlet extends HttpServlet {
    private TaskDao taskDao;

    public void init() {
        this.taskDao = new TaskDao();
    }
    int[][] allBallArray = new int[50][50];

    @Override
//заполняем типа
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        String tasky = req.getParameter("tasky"); //ответ введенный
        if (session.getAttribute("task-home") == null) {
            session.setAttribute("page",1);
            int id = Integer.parseInt(req.getParameter("taskTypeId")); //получаем тип задач
            TaskTypeDao dao = new TaskTypeDao();
            TaskType course = dao.getTaskType(id);
            String task= course.getTask();
            session.setAttribute("task", task);
            session.setAttribute("taskTypeId", id);
            List<TaskType> qtList1 = dao.getAllTask(id);
            session.setAttribute("taskAllList", qtList1);
        } else {
            session.setAttribute("page", req.getParameter("page"));
            session.setAttribute("questionId", req.getParameter("questionId"));
        }
        req.getRequestDispatcher("/task-screen").forward(req,res);
    }

//    получаем типа
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        String tasky = req.getParameter("tasky");
        System.out.println(tasky+" Введенный ответ");
        int id = (int) session.getAttribute("taskTypeId");
        String idTask = req.getParameter("TaskId");
        int TaskId = Integer.parseInt(idTask);
        System.out.println(idTask+" номер ЗАДАЧИ в задачи");
        PrintWriter writer = res.getWriter();
        res.setContentType("text/html");
        String username = (String)session.getAttribute("username");
        req.getRequestDispatcher("/taskScreen.jsp").include(req, res);



        if(taskDao.checkAnswer1(TaskId, tasky)){
            allBallArray[id][TaskId]=2;
            writer.println(
                    "<div class='content'><h1> Верно</h1></div>"
            );
        }
        else{
            writer.println(
                    "<h2>Неверно</h2></h2>"
            );
        }

        int sum1=0;
        for (int i = id; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                sum1 = sum1 + allBallArray[i][j];
            }
        }

        Arrays.stream(allBallArray).map(Arrays::toString).forEach(System.out::println);
        System.out.println(sum1+" Всего баллов из МАССИВА");
        UserDao dao = new UserDao();
        System.out.println("Номер ТИПА задачи: "+id);
        dao.addBall(username, sum1, id);
        UserDao qq = new UserDao();
        int sumBall = qq.allResult(username).getResult();

        if (sumBall>=10){

        }
        else{

        }
    }
}
