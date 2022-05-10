package com.clarkngo.quizme.web.domain.task;


public class TaskJson {
    private TaskType taskType;
    private String questions;

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

}
