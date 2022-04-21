package com.clarkngo.quizme.web.domain;

public class Chat {
    private int chatId;
    private int fkQuizTypeIdChat;
    private String chat;

    public int getFeedbackId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public int getFkQuizTypeIdChat() {
        return fkQuizTypeIdChat;
    }

    public void setFkQuizTypeIdChat(int fkQuizTypeIdChat) {
        this.fkQuizTypeIdChat = fkQuizTypeIdChat;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "chatId=" + chatId +
                ", fkQuizTypeIdChat=" + fkQuizTypeIdChat +
                ", chat='" + chat + '\'' +
                '}';
    }
}
