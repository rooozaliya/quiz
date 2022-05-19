package com.clarkngo.quizme.web.dao;

import com.clarkngo.quizme.web.config.MySqlDS;
import com.clarkngo.quizme.web.domain.Chat;
import com.clarkngo.quizme.web.domain.Feedback;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDao {

    private DataSource ds;
    private Connection conn;

    public FeedbackDao() {
        this.ds = MySqlDS.getDs();
    }

    private PreparedStatement ps;

    public void addFeedback(int quizTypeId, int rating, String description) {
        try {
            this.conn = ds.getConnection();
            ps = conn.prepareStatement("INSERT INTO feedback (Fk_QuizTypeId_Feedback, Rating, Description) VALUES (?,?,?)");
            ps.setInt(1, quizTypeId);
            ps.setInt(2, rating);
            ps.setString(3, description);
            ps.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Feedback> showFeedback() {
        List<Feedback> listFeedback = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            this.conn = ds.getConnection();
            ps = conn.prepareStatement("SELECT * FROM feedback");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Feedback feedback = new Feedback();
                // chat.setUserId(rs.getInt("idUser"));
                feedback.setRating(rs.getInt("Rating"));
                feedback.setDescription(rs.getString("Description"));
                System.out.println("Students : "  + feedback );
                listFeedback.add(feedback);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return listFeedback;

    }
}
