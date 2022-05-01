package com.clarkngo.quizme.web.domain;


import java.util.List;

public class TheoryType {
    private int theoryId;
    private String name;
    private String description;
    private String ImageUrl;
    private String Image;
    private List<Question> questions;
    private String questionsJson;
    private Feedback feedback;

    public TheoryType() {
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }


    public int getTheoryId() {
        return theoryId;
    }

    public void setTheoryId(int theoryId) {
        this.theoryId = theoryId;
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

    @Override
    public String toString() {
        return "QuizType{" +
                "quizTypeId=" + theoryId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ImageUrl='" + ImageUrl + '\'' +
                ", questions=" + questions +
                ", feedback=" + feedback +
                '}';
    }
}
