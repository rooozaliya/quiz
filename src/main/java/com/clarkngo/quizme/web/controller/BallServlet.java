
package com.clarkngo.quizme.web.controller;

        import com.clarkngo.quizme.web.dao.UserDao;
        import com.clarkngo.quizme.web.domain.User;

        import javax.servlet.*;
        import javax.servlet.http.*;
        import javax.servlet.annotation.*;
        import java.io.IOException;
        import java.util.List;



@WebServlet(name = "BallServlet", value = "/ball")
public class BallServlet extends HttpServlet {

    private UserDao userDao;

    public void init() {this.userDao = new UserDao();}
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        HttpSession oldSession = req.getSession(false);
        UserDao dao = new UserDao();
        List<User> listUser1 = dao.listAllUsers();
      //  session.setAttribute("listUser", listUser1);

        if (oldSession == null) {
            res.sendRedirect("/error");
        } else {

            session.setAttribute("listUser", listUser1);

        }

        req.getRequestDispatcher("/ball.jsp").include(req, res);
        req.getRequestDispatcher("/ball.jsp").forward(req, res);



    }



    }






