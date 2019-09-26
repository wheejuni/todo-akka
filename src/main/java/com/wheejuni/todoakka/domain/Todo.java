package com.wheejuni.todoakka.domain;

import java.time.LocalDateTime;

public class Todo {

    private String title;
    private String content;
    private LocalDateTime due;

    public Todo(String title, String content, LocalDateTime due) {
        this.title = title;
        this.content = content;
        this.due = due;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDue() {
        return due;
    }

    public void setDue(LocalDateTime due) {
        this.due = due;
    }
}
