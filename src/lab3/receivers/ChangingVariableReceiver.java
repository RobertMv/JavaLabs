package lab3.receivers;

import lab3.events.ChangingVariable;

public class ChangingVariableReceiver implements ChangingVariable {
    private final String message = "EVENT: Changing variable's value";

    @Override
    public void Handler() {
        System.out.println(message);
    }

    public String getMessage() {
        return message;
    }
}
