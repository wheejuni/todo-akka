package com.wheejuni.todoakka.domain.search;

import com.wheejuni.todoakka.domain.Todo;
import com.wheejuni.todoakka.domain.repositories.TodoRepository;
import com.wheejuni.todoakka.view.params.TodoSearchParameter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

/**
 * @author Hwi Jun Jeong(KR19385) created on 2019-09-26
 */
public class TodoSearchParamResolver implements SearchParamResolver<Todo, TodoSearchParameter> {

    private TodoRepository todoRepository;

    public TodoSearchParamResolver(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo matches(TodoSearchParameter predicate) {
        return todoRepository.getAll().stream()
            .filter(todo -> todo.isMatchingPredicate(predicate))
            .findFirst().orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Todo> multiMatches(TodoSearchParameter predicate) {
        return todoRepository.getAll().stream()
            .filter(todo -> todo.isMatchingPredicate(predicate))
            .collect(Collectors.toList());
    }
}
