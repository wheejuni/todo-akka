package com.wheejuni.todoakka.application;

import akka.Done;
import com.wheejuni.todoakka.domain.Todo;
import com.wheejuni.todoakka.domain.repositories.TodoRepository;
import com.wheejuni.todoakka.view.params.TodoSearchParameter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void saveTodo(Todo todo) {
        todoRepository.saveTodo(todo);
    }

    public CompletionStage<Done> asyncSaveTodo(Todo todo) {
        this.todoRepository.saveTodo(todo);
        return CompletableFuture.completedFuture(Done.getInstance());
    }

    public Todo getSingleTodo(TodoSearchParameter todoSearchParameter) {
        return todoRepository.getTodo(todoSearchParameter);
    }

    public CompletionStage<Optional<Todo>> getAsyncSingleTodo(TodoSearchParameter todoSearchParameter) {
        Todo fetchedTodo = this.todoRepository.getTodo(todoSearchParameter);

        return CompletableFuture.completedFuture(fetchedTodo == null ? Optional.empty() : Optional.of(fetchedTodo));
    }

    public List<Todo> getMultiTodos(TodoSearchParameter todoSearchParameter) {
        return todoRepository.getTodos(todoSearchParameter);
    }

    public CompletionStage<List<Todo>> getAsyncMultiTodo(TodoSearchParameter parameter) {
        List<Todo> todos = this.todoRepository.getTodos(parameter);

        return CompletableFuture.completedFuture(todos);
    }

    public List<Todo> getTodosUntil(LocalDateTime until) {
        return todoRepository.getTodosDueUntil(until);
    }
}
