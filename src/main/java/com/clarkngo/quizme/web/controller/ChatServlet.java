package com.clarkngo.quizme.web.controller;

import com.clarkngo.quizme.web.dao.ChatDao;
import com.clarkngo.quizme.web.dao.FeedbackDao;
import com.clarkngo.quizme.web.dao.UserDao;
import com.clarkngo.quizme.web.domain.Chat;
import com.clarkngo.quizme.web.domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ChatServlet", value = "/chat")
public class ChatServlet extends HttpServlet {

    private ChatDao chatDao1;

    public void init() {this.chatDao1 = new ChatDao();}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
       // req.getRequestDispatcher("/chat.jsp").forward(req,res);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");

        ChatDao dao = new ChatDao();
        List<Chat> listChat1 = dao.showChat();
        session.setAttribute("listChats", listChat1);
        req.getRequestDispatcher("/chat.jsp").forward(req, res);
        System.out.println(listChat1+"aaaaaaaaa");

        req.getRequestDispatcher("/chat.jsp").include(req, res);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        req.getRequestDispatcher("/chat.jsp").forward(req,res);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        String description = req.getParameter("description");
        int userId = Integer.parseInt(req.getParameter("userId"));
//        System.out.println(description);
//        System.out.println(userId);
        chatDao1.addChat(userId, description);

    }
}
