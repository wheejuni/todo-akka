package com.wheejuni.todoakka.view.params;

import com.wheejuni.todoakka.domain.search.SearchPredicate;
import java.time.LocalDateTime;

public class TodoSearchParameter implements SearchPredicate {

    private LocalDateTime since;
    private String title;
    private String contentIncluding;

    public LocalDateTime getSince() {
        return since;
    }

    public void setSince(LocalDateTime since) {
        this.since = since;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentIncluding() {
        return contentIncluding;
    }

    public void setContentIncluding(String contentIncluding) {
        this.contentIncluding = contentIncluding;
    }
}
