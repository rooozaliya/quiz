package com.clarkngo.quizme.web.domain.task;

import com.clarkngo.quizme.web.domain.Question;


import java.util.List;

public class Task {
    private TaskType taskType;
    private List<Question> questions;
    private String questionsJson;
    private int queID;

    public String getQuestionsJson() {
        return questionsJson;
    }

    public void setQuestionsJson(String questionsJson) {
        this.questionsJson = questionsJson;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskType=" + taskType +
                ", questions=" + questions +
                '}';
    }

    public int getQueID() {
        return queID;
    }

    public void setQueID(int queID) {
        this.queID = queID;
    }
}
