package com.clarkngo.quizme.web.dao;

import com.clarkngo.quizme.web.config.MySqlDS;
import com.clarkngo.quizme.web.domain.Choice;
import com.clarkngo.quizme.web.domain.Course;
import com.clarkngo.quizme.web.domain.Question;
import com.clarkngo.quizme.web.domain.Quiz;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class CourseJsonDao {

    private DataSource ds;
    private Connection conn;

    public CourseJsonDao() {
        this.ds = MySqlDS.getDs();
    }

    private PreparedStatement ps;
    public Course getQuiz(int id) {
        Course course = new Course();

        course.setCourseType(new CourseTypeDao().getCourseType(id));
        List<Question> questions = new QuestionDao().getTenRandomQuestions(id);

        for (int i=0; i < questions.size(); i++) {
            int questionId = questions.get(i).getQuestionId();
            List<Choice> choices = new ChoiceDao().getChoices(questionId);
            Gson gson = new Gson();
            JsonArray jarray = gson.toJsonTree(choices).getAsJsonArray();
            System.out.println(jarray);
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("choices", jarray);

            questions.get(i).setChoicesJson(jsonObject.get("choices").toString());
        }

        Gson gson = new Gson();
        JsonArray jarray = gson.toJsonTree(questions).getAsJsonArray();
        System.out.println(jarray);
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("questions", jarray);
        course.setQuestionsJson(jsonObject.get("questions").toString());


        return course;
    }
}
