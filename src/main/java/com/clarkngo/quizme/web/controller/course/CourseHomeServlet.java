//ПРОСТО СПИСОК КУРСОВ

package com.clarkngo.quizme.web.controller.course;

import com.clarkngo.quizme.web.dao.UserDao;
import com.clarkngo.quizme.web.dao.course.CourseTypeDao;
import com.clarkngo.quizme.web.domain.course.CourseType;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CourseHomeServlet", value = "/course")
public class CourseHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");

        CourseTypeDao dao = new CourseTypeDao();
        List<CourseType> qtList = dao.getCourseTypes();
        HttpSession oldSession = req.getSession(false);
        String username = (String)oldSession.getAttribute("username");
        UserDao qq = new UserDao();
        String name = qq.oneUser1(username).getName();
        int ball = qq.allResult(username).getResult();
        oldSession.setAttribute("ball", ball);


//        PrintWriter writer = res.getWriter();
//        res.setContentType("text/html");
//        UserDao qq = new UserDao();
//        int sumBall = qq.allResult(username).getResult();
//
//        if (sumBall>=10){
//
//            System.out.println("aaaaaaaaaaaaaaaaa");
//
//        }
//        else{
//
//        }

//        CourseType course = dao.getCourseType(2);
//        session.setAttribute("courseType", course);
        session.setAttribute("courseTypeList", qtList);
        req.getRequestDispatcher("/course-page").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        System.out.println(req.getParameter("courseTypeId"+"str36"));
        System.out.println(req.getParameter("page"+"str37"));
        System.out.println(req.getParameter("questionId"+"str38"));
        res.sendRedirect(req.getContextPath() + "/course-screen");

    }
}
