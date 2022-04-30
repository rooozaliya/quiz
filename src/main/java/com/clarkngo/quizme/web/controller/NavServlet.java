
package com.clarkngo.quizme.web.controller;

        import com.clarkngo.quizme.web.dao.UserDao;

        import javax.servlet.*;
        import javax.servlet.http.*;
        import javax.servlet.annotation.*;
        import java.io.IOException;
        import java.io.PrintWriter;

@WebServlet(name = "NavServlet", value = "/nav")
public class NavServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        HttpSession oldSession = req.getSession(false);
        String username = (String)oldSession.getAttribute("username");
       // HttpSession session = req.getSession(true);
        oldSession.setAttribute("username", username);
//        if(username == null) {
//            writer.println(String.format("<h2>Welcome!</h2>"));
//        } else {
//            req.getRequestDispatcher("/nav.jsp").include(req, resp);
//            writer.println(String.format("<h2>Welcome Username: %s</h2>", username));
//        }
        writer.close();
    }
}