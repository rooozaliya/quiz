package com.clarkngo.quizme.web.domain.course;

public class CourseJson {
    private CourseType courseType;
    private String questions;

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

}
