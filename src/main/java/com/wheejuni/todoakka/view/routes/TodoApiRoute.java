package com.wheejuni.todoakka.view.routes;

import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;

public class TodoApiRoute extends AllDirectives {

    public static Route createRoute() {
        return concat(
                path("hello", () -> get(() -> complete("hello akka")))
        );
    }
}
