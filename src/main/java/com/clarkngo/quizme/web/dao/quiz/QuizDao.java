package com.clarkngo.quizme.web.dao.quiz;

import com.clarkngo.quizme.web.config.MySqlDS;
import com.clarkngo.quizme.web.dao.ChoiceDao;
import com.clarkngo.quizme.web.dao.QuestionDao;
import com.clarkngo.quizme.web.domain.quiz.Quiz;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuizDao {
    private DataSource ds;
    private Connection conn;

    public QuizDao() {
        this.ds = MySqlDS.getDs();
    }

    private PreparedStatement ps;
    public Quiz getQuiz(int id) {
        Quiz quiz = new Quiz();

        quiz.setQuizType(new QuizTypeDao().getQuizType(id));
        quiz.setQuestions(new QuestionDao().getTenRandomQuestions(id));
        for (int i=0; i < quiz.getQuestions().size(); i++) {
            int questionId = quiz.getQuestions().get(i).getQuestionId();
            quiz.getQuestions().get(i).setChoices(new ChoiceDao().getChoices(questionId));
        }
        return quiz;
    }
}
