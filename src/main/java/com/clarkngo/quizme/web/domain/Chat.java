package com.clarkngo.quizme.web.domain;

public class Chat {
    private int chatId;
    private int userId;
    private String description;

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }
    public int getChatId() {
        return chatId;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Chat{" +
//                "chatId=" + chatId +
                ", description=" + description +
//                ", userId ='" + userId + '\'' +
                '}';
    }
}
