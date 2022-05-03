//НЕПОНЯТНО ДЛЯ ЧЕГО НУЖНО

//package com.clarkngo.quizme.web.controller;

//
//import com.clarkngo.quizme.web.dao.QuestionDao;
//import com.clarkngo.quizme.web.domain.Question;
//import com.clarkngo.quizme.web.util.JsonConverter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.List;
//
//@WebServlet(name = "GetCourseServlet", value = "/coursejson")
//public class GetCourseServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        int id = Integer.parseInt(request.getParameter("courseTypeId"));
//        response.setContentType("application/json;charset=UTF-8");
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//       // ServletOutputStream out = response.getOutputStream();
//
//        List<Question> course = new QuestionDao().getTenRandomQuestions(id);
//
//        JsonConverter converter = new JsonConverter();
//        String output = converter.convertToJson(course);
//        PrintWriter out = response.getWriter();
//        out.print(output);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//}
