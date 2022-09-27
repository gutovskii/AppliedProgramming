package com.lab3.application;

import com.lab3.interaction.UserInteraction;

public class Application {
    public static void run() {
        UserInteraction userInteraction = new UserInteraction();
        userInteraction.chooseTasks();
    }
}
