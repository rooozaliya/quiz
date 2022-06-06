package com.clarkngo.quizme.web.dao.task;

import com.clarkngo.quizme.web.config.MySqlDS;

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
//    public Task getTask(int id) {
//        Task task = new Task();
//
//        task.setTaskType(new TaskTypeDao().getTaskType(id));
//        task.setQuestions(new QuestionDao().getTenRandomQuestions(id));
//        for (int i=0; i < task.getQuestions().size(); i++) {
//            int questionId = task.getQuestions().get(i).getQuestionId();
//            task.getQuestions().get(i).setChoices(new ChoiceDao().getChoices(questionId));
//        }
//        return task;
//    }

    public boolean checkAnswer1(int taskId, String answer)
    {
        boolean st =false;
        try {
            this.conn = ds.getConnection();

            ps = conn.prepareStatement("SELECT * FROM task WHERE TaskId=? AND answer=?");
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

    public void addTheory( String name, String description, String theory, String link) {
        try {

            this.conn = ds.getConnection();
            ps = conn.prepareStatement("INSERT into coursetype (Name, Description, Theory, VideoLink) VALUES (?, ?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setString(3, theory);
            ps.setString(4, link);
            ps.executeUpdate();

        }
        catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void addQuestion(int testId, String question) {
        try {

            this.conn = ds.getConnection();
            ps = conn.prepareStatement("INSERT into question (Fk_QuizTypeId_Question, Description) VALUES (?, ?)");
            ps.setInt(1, testId);
            ps.setString(2, question);
            ps.executeUpdate();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Task getQueID(String question) {
        Task task = new Task();
        try {

            this.conn = ds.getConnection();
            ps = conn.prepareStatement("SELECT * FROM question WHERE Description=?");
            ps.setString(1, question);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                task.setQueID(rs.getInt("Id"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return task;
    }

    public void addAnswerForQue(int questionId,  String all_answer) {
        try {
            this.conn = ds.getConnection();
            ps = conn.prepareStatement("INSERT into choice (Fk_QuestionId_Choice, Description, IsAnswer) VALUES (?, ?, 0)");
            ps.setInt(1, questionId);
            ps.setString(2, all_answer);
       //     ps.setString(3, right_answer);
            ps.executeUpdate();

        }
        catch (Exception e) {
            e.printStackTrace();

        }
    }
    public void addTrueAnswerForQue(int questionId,  String right_answer) {
        try {
            this.conn = ds.getConnection();
            ps = conn.prepareStatement("INSERT into choice (Fk_QuestionId_Choice, Description, IsAnswer) VALUES (?, ?, 1)");
            ps.setInt(1, questionId);
            ps.setString(2, right_answer);
            ps.executeUpdate();

        }
        catch (Exception e) {
            e.printStackTrace();

        }
    }

}
