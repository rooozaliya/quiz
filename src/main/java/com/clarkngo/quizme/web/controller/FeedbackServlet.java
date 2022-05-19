package com.clarkngo.quizme.web.controller;

import com.clarkngo.quizme.web.dao.ChatDao;
import com.clarkngo.quizme.web.dao.FeedbackDao;
import com.clarkngo.quizme.web.dao.UserDao;
import com.clarkngo.quizme.web.domain.Chat;
import com.clarkngo.quizme.web.domain.Feedback;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
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
        System.out.println(rating);
        System.out.println(description);
        System.out.println(quizTypeId);
        feedbackDao.addFeedback(quizTypeId, rating, description);
        res.setContentType("text/html");
        PrintWriter writer = res.getWriter();
        req.getRequestDispatcher("/chat.jsp").forward(req, res);
        writer.print(
                "<div class='container'>" +
                        "<h2 style='color: green;'>Спасибо, отзыв отправлен</h2>" +
                        "</div>"
        );
        writer.println(String.format("<h2>Оценка: %s, Сообщение: %s</h2>", rating, description));



        writer.close();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(true);
        FeedbackDao dao = new FeedbackDao();
        List<Feedback> listFeedback = dao.showFeedback();
        session.setAttribute("listFeedback", listFeedback);
        System.out.println(listFeedback+"aaaaaaaaa");
        request.getRequestDispatcher("/feedbackForm.jsp").forward(request, response);
        request.getRequestDispatcher("/feedbackForm.jsp").include(request, response);

    }
}
