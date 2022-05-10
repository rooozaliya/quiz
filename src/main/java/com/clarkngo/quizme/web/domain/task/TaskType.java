package com.clarkngo.quizme.web.domain.task;


import com.clarkngo.quizme.web.domain.Feedback;
import com.clarkngo.quizme.web.domain.Question;

import java.util.List;

public class TaskType {
    private int taskTypeId;
    private String name;
    private String description;
    private String task;
    private String ImageUrl;
    private String ImgUrl;
    private List<Question> questions;
    private String questionsJson;
    private Feedback feedback;

    public TaskType() {
    }


    public int getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(int taskTypeId) {
        this.taskTypeId = taskTypeId;
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

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
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


    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "QuizType{" +
                "quizTypeId=" + taskTypeId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ImageUrl='" + ImageUrl + '\'' +
                ", questions=" + questions +
                ", feedback=" + feedback +
                '}';
    }
}
