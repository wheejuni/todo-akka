package com.wheejuni.todoakka.domain;

import com.wheejuni.todoakka.domain.search.SearchPredicate;
import com.wheejuni.todoakka.domain.search.SearchableEntityBase;
import com.wheejuni.todoakka.view.params.TodoSearchParameter;
import java.time.LocalDateTime;

public class Todo implements SearchableEntityBase<TodoSearchParameter> {

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

    @Override
    public boolean isMatchingPredicate(TodoSearchParameter predicate) {
        boolean matching = false;

        if(predicate.getTitle().equals(this.title)) {
            matching = true;
        }

        if(this.content.contains(predicate.getContentIncluding())) {
            matching = true;
        }

        if(this.due.isBefore(predicate.getSince())) {
            matching = true;
        }

        return matching;
    }
}
