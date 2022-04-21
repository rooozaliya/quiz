package com.clarkngo.quizme.web.dao;

import com.clarkngo.quizme.web.config.MySqlDS;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ChatDao {

    private DataSource ds;
    private Connection conn;

    public ChatDao() {
        this.ds = MySqlDS.getDs();
    }

    private PreparedStatement ps;

    public void addChat(int quizTypeId, String chat) {
        try {
            this.conn = ds.getConnection();
            ps = conn.prepareStatement("INSERT INTO chat (Fk_QuizTypeId_Chat, Chat) VALUES (?,?)");
            ps.setInt(1, quizTypeId);
            ps.setString(2, chat);
            ps.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
