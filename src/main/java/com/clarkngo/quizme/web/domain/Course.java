package com.clarkngo.quizme.web.domain;

import java.util.List;

public class Course {
    private CourseType courseType;
    private List<Question> questions;
    private String questionsJson;

    public String getQuestionsJson() {
        return questionsJson;
    }

    public void setQuestionsJson(String questionsJson) {
        this.questionsJson = questionsJson;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "quizType=" + courseType +
                ", questions=" + questions +
                '}';
    }
}
