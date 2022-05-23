

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

@WebServlet(name = "AddQuestionServlet", value = "/add-question")
public class AddQuestionServlet extends HttpServlet {

    private TaskDao taskDao;

    public void init() {this.taskDao = new TaskDao();}


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/addNewTask.jsp").forward(req,res);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(true);
        req.getRequestDispatcher("/addNewTask.jsp").forward(req,res);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        String question = req.getParameter("question");
        System.out.println("Название задачи: "+question);
        String right_answer = req.getParameter("right_answer");
        System.out.println("Заполнение right_answer: "+right_answer);
        String answer_1 = req.getParameter("answer_1");
        String answer_2 = req.getParameter("answer_2");
        String answer_3 = req.getParameter("answer_3");
        System.out.println("Заполнение all_answer: "+answer_1+ answer_2+answer_3);
        String tI = req.getParameter("testId");
        int testId =Integer.parseInt(tI);
        taskDao.addQuestion(testId, question);
        int QueId = taskDao.getQueID(question).getQueID();
        taskDao.addAnswerForQue(QueId,answer_1);
        taskDao.addAnswerForQue(QueId,answer_2);
        taskDao.addAnswerForQue(QueId,answer_3);
        taskDao.addTrueAnswerForQue(QueId, right_answer);
        res.setContentType("text/html");
        req.getRequestDispatcher("/addNewTask.jsp").include(req,res);

    }
}
