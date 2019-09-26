package com.wheejuni.todoakka.view.routes;

import akka.Done;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import akka.http.scaladsl.model.StatusCode;
import com.wheejuni.todoakka.application.TodoService;
import com.wheejuni.todoakka.domain.Todo;
import com.wheejuni.todoakka.domain.repositories.TodoRepository;
import java.util.concurrent.CompletionStage;

public class TodoApiRoute extends AllDirectives {
    private static TodoApiRoute todoApiRoute = null;

    private TodoService todoService;

    public TodoApiRoute(TodoService todoService) {
        this.todoService = todoService;
    }

    public Route createRoute() {
        return concat(
                path("hello", () -> get(() -> complete("hello akka"))),
                path("api", () -> get(() -> complete("hello this is api v1."))),
                post(() ->
                    path("save", () -> entity(Jackson.unmarshaller(Todo.class), todo -> {
                        CompletionStage<Done> futureSaved = todoService.asyncSaveTodo(todo);
                        return onSuccess(futureSaved, done -> complete(StatusCode.int2StatusCode(200), "todo saved"));
                    })))
        );
    }
}
