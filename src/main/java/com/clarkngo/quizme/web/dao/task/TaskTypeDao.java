package com.clarkngo.quizme.web.dao.task;

import com.clarkngo.quizme.web.config.MySqlDS;
import com.clarkngo.quizme.web.domain.task.TaskType;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskTypeDao {
    private DataSource ds;
    private Connection conn;


    public TaskTypeDao() {
        this.ds = MySqlDS.getDs();
    }

    public List<TaskType> getTaskTypes() {
        List<TaskType> taskTypes = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            this.conn = ds.getConnection();
            ps = conn.prepareStatement("SELECT * FROM tasktype");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaskType qt = new TaskType();
                qt.setTaskTypeId(rs.getInt("Id"));
                qt.setName(rs.getString("Name"));
                qt.setDescription(rs.getString("Description"));
                qt.setTask(rs.getString("task"));
                qt.setAnswer(rs.getString("answer"));

               // qt.setImageUrl(rs.getString("ImageURL"));
               // qt.setImgUrl(rs.getString("ImgURL"));
                taskTypes.add(qt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return taskTypes;
    }

    public TaskType getTaskType(int id) {
        TaskType taskType = new TaskType();
        PreparedStatement ps = null;
        try {
            this.conn = ds.getConnection();
            ps = conn.prepareStatement("SELECT * FROM tasktype WHERE Id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                taskType.setTaskTypeId(rs.getInt("Id"));
                taskType.setName(rs.getString("Name"));
                taskType.setDescription(rs.getString("Description"));
                taskType.setTask(rs.getString("task"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return taskType;
    }
//SELECT * FROM task INNER JOIN tasktype ON  task.idTask = tasktype.id;
    public List<TaskType> getAllTask(int id) {
        List<TaskType> taskTypes = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            this.conn = ds.getConnection();
            ps = conn.prepareStatement("SELECT * FROM task INNER JOIN tasktype ON  task.idTask = tasktype.id where tasktype.id=? ");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TaskType qt = new TaskType();
                qt.setTaskId(rs.getInt("TaskId"));
                qt.setName(rs.getString("Name"));
                qt.setDescription(rs.getString("Description"));
                qt.setTask(rs.getString("Task"));
                qt.setAnswer(rs.getString("answer"));

                // qt.setImageUrl(rs.getString("ImageURL"));
                // qt.setImgUrl(rs.getString("ImgURL"));
                taskTypes.add(qt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return taskTypes;
    }
}
