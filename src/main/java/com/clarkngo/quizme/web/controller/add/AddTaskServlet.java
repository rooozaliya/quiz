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

@WebServlet(name = "AddTaskServlet", value = "/add-task")
public class AddTaskServlet extends HttpServlet {

    private TaskDao taskDao;

    public void init() {this.taskDao = new TaskDao();}


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/addNewTask.jsp").forward(req,res);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(true);
//        int id = Integer.parseInt(req.getParameter("taskTypeId"));
//        TaskTypeDao dao = new TaskTypeDao();
//        TaskType task = dao.getTaskType(id);
//        String taskA= task.getTask();
//        session.setAttribute("task", taskA);
//        session.setAttribute("taskTypeId", id);
        req.getRequestDispatcher("/addNewTask.jsp").forward(req,res);
    }

      protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        String nameS = req.getParameter("name");
        int name =Integer.parseInt(nameS);
        System.out.println("Название задачи: "+name);
        String task = req.getParameter("task");
        System.out.println("Заполнение задачи: "+task);
        String answer = req.getParameter("answer");
        System.out.println("Заполнение ответа: "+answer);
        taskDao.addTask(name, task, answer);
          String theory = req.getParameter("theory");
          System.out.println("Заполнение теории: "+theory);
        HttpSession oldSession = req.getSession(false);
        String username = (String)oldSession.getAttribute("username");
        res.setContentType("text/html");
        req.getRequestDispatcher("/addNewTask.jsp").include(req,res);

       }
}
