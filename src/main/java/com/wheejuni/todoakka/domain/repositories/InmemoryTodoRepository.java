package com.wheejuni.todoakka.domain.repositories;

import com.wheejuni.todoakka.domain.Todo;
import com.wheejuni.todoakka.view.params.TodoSearchParameter;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Hwi Jun Jeong(KR19385) created on 2019-09-26
 */
public class InmemoryTodoRepository implements TodoRepository {

    private ConcurrentHashMap<UUID, Todo> todoStorage = new ConcurrentHashMap<>();

    @Override
    public Todo getTodo(TodoSearchParameter parameter) {
        return null;
    }

    @Override
    public void saveTodo(Todo todo) {
        todoStorage.put(generateTodoId(), todo);
    }

    @Override
    public List<Todo> getTodos(TodoSearchParameter parameter) {
        return null;
    }

    @Override
    public List<Todo> getTodosDueUntil(LocalDateTime due) {
        return null;
    }

    private UUID generateTodoId() {
        return UUID.randomUUID();
    }
}
