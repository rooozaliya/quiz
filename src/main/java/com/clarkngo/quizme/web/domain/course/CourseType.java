package com.clarkngo.quizme.web.domain.course;


import com.clarkngo.quizme.web.domain.Feedback;
import com.clarkngo.quizme.web.domain.Question;

import java.util.List;

public class CourseType {
    private int courseTypeId;
    private String name;
    private String description;
    private String theory;
    private String ImageUrl;
    private String Image;
    private String Link;
    private List<Question> questions;
    private String questionsJson;
    private Feedback feedback;

    public CourseType() {
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }


    public int getCourseTypeId() {
        return courseTypeId;
    }

    public void setCourseTypeId(int courseTypeId) {
        this.courseTypeId = courseTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public String getTheory() {
        return theory;
    }

    public void setTheory(String theory) {
        this.theory = theory;
    }


    @Override
    public String toString() {
        return "QuizType{" +
                "quizTypeId=" + courseTypeId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ImageUrl='" + ImageUrl + '\'' +
                ", questions=" + questions +
                ", feedback=" + feedback +
                '}';
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }
}
