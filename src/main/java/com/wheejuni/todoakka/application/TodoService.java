package com.wheejuni.todoakka.application;

import com.wheejuni.todoakka.domain.Todo;
import com.wheejuni.todoakka.domain.repositories.TodoRepository;
import com.wheejuni.todoakka.view.params.TodoSearchParameter;

import java.time.LocalDateTime;
import java.util.List;

public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void saveTodo(Todo todo) {
        todoRepository.saveTodo(todo);
    }

    public Todo getSingleTodo(TodoSearchParameter todoSearchParameter) {
        return todoRepository.getTodo(todoSearchParameter);
    }

    public List<Todo> getMultiTodos(TodoSearchParameter todoSearchParameter) {
        return todoRepository.getTodos(todoSearchParameter);
    }

    public List<Todo> getTodosUntil(LocalDateTime until) {
        return todoRepository.getTodosDueUntil(until);
    }
}
