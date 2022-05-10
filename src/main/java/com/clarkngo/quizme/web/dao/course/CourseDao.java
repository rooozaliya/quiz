package com.clarkngo.quizme.web.dao.course;

import com.clarkngo.quizme.web.config.MySqlDS;
import com.clarkngo.quizme.web.dao.ChoiceDao;
import com.clarkngo.quizme.web.dao.QuestionDao;
import com.clarkngo.quizme.web.domain.course.Course;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CourseDao {
    private DataSource ds;
    private Connection conn;

    public CourseDao() {
        this.ds = MySqlDS.getDs();
    }

    private PreparedStatement ps;
    public Course getCourse(int id) {
        Course course = new Course();
        course.setCourseType(new CourseTypeDao().getCourseType(id));
        course.setQuestions(new QuestionDao().getTenRandomQuestions(id));
        for (int i=0; i < course.getQuestions().size(); i++) {
            int questionId = course.getQuestions().get(i).getQuestionId();
            course.getQuestions().get(i).setChoices(new ChoiceDao().getChoices(questionId));
        }
        return course;
    }
}
