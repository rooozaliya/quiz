package com.clarkngo.quizme.web.controller;

import com.clarkngo.quizme.web.config.MySqlDS;
import com.clarkngo.quizme.web.dao.UserDao;
import com.clarkngo.quizme.web.domain.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



@WebServlet(name = "AdminServlet", value = "/admin-form")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");

        UserDao dao = new UserDao();
        List<User> listUser1 = dao.listAllUsers();
        session.setAttribute("listUser", listUser1);
        req.getRequestDispatcher("/admin.jsp").forward(req, res);
        HttpSession oldSession = req.getSession(false);
        PrintWriter writer = res.getWriter();
        req.getRequestDispatcher("/admin.jsp").include(req, res);
        if (oldSession == null) {

            writer.print(
                    "<h1>Авторизуйся</h1>"
            );
            writer.close();
        } else {
            String username = (String) oldSession.getAttribute("username");
            if (username.equals("rooozaliya@mail.ru")) {
                writer.print(
                        "<h1>Админ</h1>"
                );
                writer.close();
            } else if (oldSession != null) {
                writer.print(
                        "<h1>Не админ</h1>"
                );
                writer.close();
            }
        }



       // System.out.println(listUser1+"1111111111111");
     //  Model model = addAttribute("allUsers", userDao.getUserId());
//        try {
//            userDao.listAllUsers();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        System.out.println(user +"ddddddddddd");
      //  getServletContext().getRequestDispatcher("/admin.jsp").forward(req, res);

//        try {
//            req.setAttribute("listUser",userDao.listAllUsers());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        //req.getRequestDispatcher("admin.jsp").forward(req,res);


//        List<User> listUser = new ArrayList<>();
//            User user = new User();
//
//            try {
//                Connection conn = ds.getConnection();
//               // conn = ds.getConnection();
//                ps = conn.prepareStatement("SELECT * FROM user");
//                // ps.setString(1, username);
//                ResultSet rs =ps.executeQuery();
//                while (rs.next()) {
////                    int id=rs.getInt("Id");
////                    req.setAttribute("Id",id);
////                    String name=rs.getString("Name");
////                    req.setAttribute("name",name);
//
//
//                    user.setUserId(rs.getInt("Id"));
//                    user.setName(rs.getString("Name"));
//                    user.setEmail(rs.getString("Email"));
//                    System.out.println("Students : " +user.getName());
//
//                    listUser.add(user);
//                    String userList =user.getName();
//                    req.setAttribute("listUser", listUser);
//                    RequestDispatcher dispatcher = req.getRequestDispatcher("admin.jsp");
//                    dispatcher.forward(req, res);
//                }
//
//                System.out.println("1 : " +user.getEmail());
//               // res.sendRedirect(req.getContextPath()+"/admin");
//            }
//            catch(Exception e) {
//                e.printStackTrace();
//            }
//        System.out.println("2 : " +user.getName());

    }





}






