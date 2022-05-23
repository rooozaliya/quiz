package com.clarkngo.quizme.web.dao.feedback;

import com.clarkngo.quizme.web.config.MySqlDS;
import com.clarkngo.quizme.web.domain.Chat;
import com.clarkngo.quizme.web.domain.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ChatDao {
    private DataSource ds;
    private Connection conn;
    public ChatDao() {
        this.ds = MySqlDS.getDs();
    }
    private PreparedStatement ps;
    public void addChat(int idUser, String description) {
        try {
            this.conn = ds.getConnection();
            ps = conn.prepareStatement("INSERT INTO chat (idUser, Description) VALUES (?,?)");
            ps.setInt(1, idUser);
            ps.setString(2, description);
            ps.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Chat> showChat() {
        List<Chat> listChat = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            this.conn = ds.getConnection();
            ps = conn.prepareStatement("SELECT * FROM chat");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Chat chat = new Chat();
               // chat.setUserId(rs.getInt("idUser"));
                chat.setDescription(rs.getString("Description"));
                System.out.println("Students : "  + chat );
                listChat.add(chat);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return listChat;

    }
}
