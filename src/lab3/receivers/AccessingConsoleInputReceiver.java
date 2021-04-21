package lab3.receivers;

import lab3.events.AccessingConsoleInput;

public class AccessingConsoleInputReceiver implements AccessingConsoleInput {
    private final String message = "EVENT: Accessing of console input stream";

    @Override
    public void Handler() {
        System.out.println(message);
    }

    public String getMessage() {
        return message;
    }
}
