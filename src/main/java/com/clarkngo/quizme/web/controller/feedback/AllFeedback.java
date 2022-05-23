package com.clarkngo.quizme.web.controller.feedback;

import com.clarkngo.quizme.web.dao.feedback.ChatDao;
import com.clarkngo.quizme.web.dao.feedback.FeedbackDao;
import com.clarkngo.quizme.web.domain.Feedback;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
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
        req.getRequestDispatcher("/allFeedback.jsp").forward(req, res);
        req.getRequestDispatcher("/allFeedback.jsp").include(req, res);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/allFeedback.jsp").forward(req,res);

    }
}
