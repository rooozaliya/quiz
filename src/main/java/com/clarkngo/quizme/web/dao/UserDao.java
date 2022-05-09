package com.clarkngo.quizme.web.dao;

import com.clarkngo.quizme.web.config.MySqlDS;
import com.clarkngo.quizme.web.domain.User;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDao {
    private DataSource ds;
    private Connection conn;
    private PreparedStatement ps;

    public UserDao() {
        this.ds = MySqlDS.getDs();
    }

    public boolean checkCredentials(String username, String password)
    {
        boolean st =false;
        try {
            this.conn = ds.getConnection();
            ps = conn.prepareStatement("SELECT * FROM user WHERE Email=? AND Password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();
            st = rs.next();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return st;
    }

    public List<User> listAllUsers() {
        List<User> listUsers = new ArrayList<>();
        PreparedStatement ps = null;
        try {
        this.conn = ds.getConnection();
        ps = conn.prepareStatement("SELECT * FROM user ORDER BY `Raitung1` DESC");
        ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("Id"));
                user.setName(rs.getString("Name"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setResult(rs.getString("Raitung"));
                user.setResult1(rs.getString("Raitung1"));
                user.setResult2(rs.getString("Raitung2"));
                user.setResult3(rs.getString("Raitung3"));
                System.out.println("Students : "  + user );
                listUsers.add(user);


//                ps.setString(2, rs.getString("Email"));

            }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return listUsers;

    }



    public boolean userExists(String username) {
        int result = 0;
        try {
            this.conn = ds.getConnection();
            ps = conn.prepareStatement("SELECT IF (EXISTS(SELECT * FROM user WHERE Email=?),1,0) AS userExists");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getInt("userExists");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result == 1;
    }

    public void addUser(String name, String username, String password) {
        try {
            this.conn = ds.getConnection();
            ps = conn.prepareStatement("INSERT INTO user (Name, Email, Password) VALUES (?,?,?)");
            ps.setString(1, name);
            ps.setString(2, username);
            ps.setString(3, password);
            ps.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  List<User> oneUser(String username) {
        List<User> user1 = new ArrayList<>();
        try {
            this.conn = ds.getConnection();
            ps = conn.prepareStatement("SELECT * FROM user WHERE Email=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setName(rs.getString("Name"));
                user1.add(user);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return user1;
    }

    public  User oneUser1(String username) {
        User user = new User();
        try {

            this.conn = ds.getConnection();
            ps = conn.prepareStatement("SELECT * FROM user WHERE Email=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setName(rs.getString("Name"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

//    public  User allResult(String username) {
//        User user = new User();
//        try {
//            this.conn = ds.getConnection();
//
//            ps = conn.prepareStatement("UPDATE  user SET Raitung=? ");
//            ps.setString(1, rs.getString("Raitung1"));
//            ps.executeUpdate();
//            ps.setString(1, user.getResult1());
//            user.setResult1(rs.getString("Raitung1"));
////            ps.setString(2, user.getResult2());
////            ps.setString(3, user.getResult3());
//            ps.setString(2, username);
//            ps.executeUpdate();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return user;
//    }
    public void addResult(String username, String result, int num) {
        try {
            this.conn = ds.getConnection();

            if (num==1){
                ps = conn.prepareStatement("UPDATE  user SET Raitung1=?   WHERE Email=?");
                ps.setString(1, result);
                ps.setString(2, username);

                ps.executeUpdate();
            }

            else if (num==2){
                ps = conn.prepareStatement("UPDATE  user SET Raitung2=?   WHERE Email=?");
                ps.setString(1, result);
                ps.setString(2, username);
                    ps.executeUpdate();
            }
            else if (num==3){
            ps = conn.prepareStatement("UPDATE  user SET Raitung3=?   WHERE Email=?");
                ps.setString(1, result);
                ps.setString(2, username);
                ps.executeUpdate();}

            else {
                ps = conn.prepareStatement("UPDATE  user SET Raitung=?   WHERE Email=?");
                ps.setString(1, result);
                ps.setString(2, username);
                ps.executeUpdate();}

        }
        catch (Exception e) {
            e.printStackTrace();

        }
    }


}
