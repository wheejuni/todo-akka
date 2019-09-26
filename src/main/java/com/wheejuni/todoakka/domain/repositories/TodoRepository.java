package com.wheejuni.todoakka.domain.repositories;

import com.wheejuni.todoakka.domain.Todo;
import com.wheejuni.todoakka.view.params.TodoSearchParameter;

import java.time.LocalDateTime;
import java.util.List;

public interface TodoRepository {

    Todo getTodo(TodoSearchParameter parameter);
    void saveTodo(Todo todo);
    List<Todo> getTodos(TodoSearchParameter parameter);
    List<Todo> getTodosDueUntil(LocalDateTime due);
    List<Todo> getAll();
}
