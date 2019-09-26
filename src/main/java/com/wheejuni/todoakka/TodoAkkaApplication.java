package com.wheejuni.todoakka;

import akka.NotUsed;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import com.wheejuni.todoakka.application.TodoService;
import com.wheejuni.todoakka.domain.repositories.InmemoryTodoRepository;
import com.wheejuni.todoakka.view.routes.TodoApiRoute;

import java.io.IOException;
import java.util.concurrent.CompletionStage;

public class TodoAkkaApplication {

    public static void main(String[] args) {
        System.out.println(WelcomeMessage.welcomeBanner());

        ActorSystem system = ActorSystem.create("routes");

        TodoService todoService = new TodoService(new InmemoryTodoRepository());
        TodoApiRoute apiRoute = new TodoApiRoute(todoService);

        final Http http = Http.get(system);
        final ActorMaterializer actorMaterializer = ActorMaterializer.create(system);

        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow = apiRoute
                .createRoute().flow(system, actorMaterializer);



        final CompletionStage<ServerBinding> binding =
                http.bindAndHandle(routeFlow, ConnectHttp.toHost("localhost", 8080), actorMaterializer);

        TerminateSignalEmitter emitter = new TerminateSignalEmitter(system);
        try {
            emitter.onApplicationRunning();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        binding.thenCompose(ServerBinding::unbind).thenAccept(unbound -> system.terminate());
    }
}
