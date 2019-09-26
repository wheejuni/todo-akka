package com.wheejuni.todoakka;

import akka.actor.ActorSystem;

import java.io.IOException;

public class TerminateSignalEmitter {

    private ActorSystem actorSystem;

    public TerminateSignalEmitter(ActorSystem actorSystem) {
        this.actorSystem = actorSystem;
    }

    public void onApplicationRunning() throws IOException {
        int inputSwitch = 0;
        boolean stopSwitch = false;

        while(!stopSwitch) {
            inputSwitch = System.in.read();
            stopSwitch = inputSwitch != 0;
        }

        System.out.println("stop signal received!");
        ApplicationSignal.resolveApplicationSignal(actorSystem, ApplicationSignal.STOP);
    }

}
