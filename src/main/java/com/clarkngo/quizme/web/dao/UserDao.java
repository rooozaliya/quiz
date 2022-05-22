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
        ps = conn.prepareStatement("SELECT * FROM user ORDER BY `sum` DESC");
        ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("Id"));
                user.setName(rs.getString("Name"));
                user.setEmail(rs.getString("Email"));
                user.setPassword(rs.getString("Password"));
                user.setResult(rs.getInt("sum"));
                user.setResult1(rs.getString("Raitung1"));
                user.setResult2(rs.getString("Raitung2"));
                user.setResult3(rs.getString("Raitung3"));
                System.out.println("Students : "  + user );
                listUsers.add(user);
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
            ps = conn.prepareStatement("INSERT INTO user (Name, Email, Password, Task1, Task2, Task3, Raitung1,Raitung2,Raitung3) VALUES (?,?,?,0,0,0,0,0,0x`)");

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

    public  User allResult(String username) {
        User user = new User();
        try {

            this.conn = ds.getConnection();
            ps = conn.prepareStatement("SELECT * FROM user WHERE Email=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setResult(rs.getInt("sum"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public void addResult(String username, String result, int num) {
        try {
            this.conn = ds.getConnection();



                if (num == 1) {
                   // if (conn.prepareStatement("Select * from user where Raitung1 is null")) {
                    ps = conn.prepareStatement("UPDATE  user SET Raitung1=? WHERE Email=? ");
                    ps.setString(1, result);
                    ps.setString(2, username);
                    //      ps.setString(3, result);
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

    public void addBall(String username, int ball, int numTask) {
        try {
            this.conn = ds.getConnection();

            if (numTask==1){
                ps = conn.prepareStatement("UPDATE  user SET Task1=?   WHERE Email=?");
                ps.setInt(1, ball);
                ps.setString(2, username);

                ps.executeUpdate();
            }

            else if (numTask==2){
                ps = conn.prepareStatement("UPDATE  user SET Task2=?   WHERE Email=?");
                ps.setInt(1, ball);
                ps.setString(2, username);
                ps.executeUpdate();
            }
            else if (numTask==3){
                ps = conn.prepareStatement("UPDATE  user SET Task3=?   WHERE Email=?");
                ps.setInt(1, ball);
                ps.setString(2, username);
                ps.executeUpdate();}

            else {
                ps = conn.prepareStatement("UPDATE  user SET ResTask=?   WHERE Email=?");
                ps.setInt(1, ball);
                ps.setString(2, username);
                ps.executeUpdate();}

        }
        catch (Exception e) {
            e.printStackTrace();

        }
    }





}
