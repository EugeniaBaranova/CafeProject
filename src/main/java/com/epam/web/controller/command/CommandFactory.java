package com.epam.web.controller.command;

public class CommandFactory {

    public static Command create(String command) {

        switch (command) {
            case "login":
                return new LoginCommand();
            default: {
                throw new UnsupportedOperationException("Unknown command" + command);
            }
        }

    }
}
