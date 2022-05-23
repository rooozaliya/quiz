package com.clarkngo.quizme.web.controller.feedback;

import com.clarkngo.quizme.web.dao.feedback.FeedbackDao;
import com.clarkngo.quizme.web.domain.Feedback;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FeedbackServlet", value = "/feedback")
public class FeedbackServlet extends HttpServlet {


    private FeedbackDao feedbackDao;

    public void init() {this.feedbackDao = new FeedbackDao();}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        int rating = Integer.parseInt(req.getParameter("rating"));
        String description = req.getParameter("description");
        int quizTypeId = Integer.parseInt(req.getParameter("quizTypeId"));
        feedbackDao.addFeedback(quizTypeId, rating, description);
        res.setContentType("text/html");
        res.sendRedirect(req.getContextPath() + "/allFeedback");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(true);
        FeedbackDao dao = new FeedbackDao();
        List<Feedback> listFeedback = dao.showFeedback();
        session.setAttribute("listFeedback", listFeedback);
        request.getRequestDispatcher("/feedbackForm.jsp").forward(request, response);
    }
}
