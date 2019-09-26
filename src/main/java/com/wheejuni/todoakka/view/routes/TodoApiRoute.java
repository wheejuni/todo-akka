package com.wheejuni.todoakka.view.routes;

import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;

public class TodoApiRoute extends AllDirectives {
    private static TodoApiRoute todoApiRoute = null;

    public static TodoApiRoute getInstance() {
        if(todoApiRoute == null) {
            todoApiRoute = new TodoApiRoute();
        }
        return todoApiRoute;
    }

    public Route createRoute() {
        return concat(
                path("hello", () -> get(() -> complete("hello akka")))
        );
    }
}
