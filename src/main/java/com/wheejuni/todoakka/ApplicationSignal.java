package com.wheejuni.todoakka;

import akka.actor.ActorSystem;

public enum ApplicationSignal {

    RUN,
    INTERRUPT,
    STOP;

    public static void resolveApplicationSignal(ActorSystem actorSystem, ApplicationSignal signal) {

        switch(signal){
            case RUN:
                break;

            case INTERRUPT:
            case STOP:
                actorSystem.terminate();
        }
    }
}
