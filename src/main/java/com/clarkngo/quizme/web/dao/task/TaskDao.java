package com.clarkngo.quizme.web.dao.task;

import com.clarkngo.quizme.web.config.MySqlDS;
import com.clarkngo.quizme.web.dao.ChoiceDao;
import com.clarkngo.quizme.web.dao.QuestionDao;
import com.clarkngo.quizme.web.domain.User;
import com.clarkngo.quizme.web.domain.quiz.Quiz;

import com.clarkngo.quizme.web.domain.task.Task;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TaskDao {
    private DataSource ds;
    private Connection conn;

    public TaskDao() {
        this.ds = MySqlDS.getDs();
    }

    private PreparedStatement ps;
    public Task getTask(int id) {
        Task task = new Task();

        task.setTaskType(new TaskTypeDao().getTaskType(id));
        task.setQuestions(new QuestionDao().getTenRandomQuestions(id));
        for (int i=0; i < task.getQuestions().size(); i++) {
            int questionId = task.getQuestions().get(i).getQuestionId();
            task.getQuestions().get(i).setChoices(new ChoiceDao().getChoices(questionId));
        }
        return task;
    }

    public boolean checkAnswer1(int taskId, String answer)
    {
        boolean st =false;
        try {
            this.conn = ds.getConnection();

            ps = conn.prepareStatement("SELECT * FROM task WHERE TaskId=? AND answer=?");
          //  ps.setInt(1, id);
            ps.setInt(1, taskId);
            ps.setString(2, answer);
            ResultSet rs =ps.executeQuery();
            st = rs.next();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;

    }

    public void addTask(int id, String task, String answer) {
        try {

            this.conn = ds.getConnection();
            ps = conn.prepareStatement("INSERT  task (Task, answer, idTask) VALUES (?,?,?)");
            ps.setString(1, task);
            ps.setString(2, answer);
            ps.setInt(3, id);
            ps.executeUpdate();

        }
        catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void addTheory( String theory, String description) {
        try {

            this.conn = ds.getConnection();
            ps = conn.prepareStatement("INSERT into coursetype (Name, Description) VALUES (?, ?)");
            ps.setString(1, theory);
            ps.setString(2, description);
            ps.executeUpdate();

        }
        catch (Exception e) {
            e.printStackTrace();

        }
    }

}
