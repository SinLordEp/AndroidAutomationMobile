package com.sinlord.aatmobile;

public class CommandHandler {
    public static String handleCommand(String command) {
        if ("TEST_COMMAND".equalsIgnoreCase(command)) {
            return "Command received and executed.";
        }
        return "Unknown command.";
    }
}
