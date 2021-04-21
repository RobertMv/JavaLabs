package lab3.receivers;

import lab3.events.EqualityOfTwoElements;

public class EqualityOfTwoElementsReceiver implements EqualityOfTwoElements {
    private final String message = "EVENT: Element is equal to default value";

    @Override
    public void Handler() {
        System.out.print(message);
    }

    public String getMessage() {
        return message;
    }
}
