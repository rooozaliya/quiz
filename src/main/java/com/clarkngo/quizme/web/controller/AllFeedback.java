package com.clarkngo.quizme.web.controller;

import com.clarkngo.quizme.web.dao.ChatDao;
import com.clarkngo.quizme.web.dao.FeedbackDao;
import com.clarkngo.quizme.web.dao.UserDao;
import com.clarkngo.quizme.web.domain.Chat;
import com.clarkngo.quizme.web.domain.Feedback;
import com.clarkngo.quizme.web.domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AllFeedback", value = "/allFeedback")
public class AllFeedback extends HttpServlet {

    private ChatDao chatDao1;

    public void init() {this.chatDao1 = new ChatDao();}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(true);
        FeedbackDao dao = new FeedbackDao();
        List<Feedback> listFeedback = dao.showFeedback();
        session.setAttribute("listFeedback", listFeedback);
        req.getRequestDispatcher("/chat.jsp").forward(req, res);
        req.getRequestDispatcher("/chat.jsp").include(req, res);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/allFeedback.jsp").forward(req,res);

    }
}
