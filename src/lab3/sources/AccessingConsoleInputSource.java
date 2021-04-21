package lab3.sources;

import lab3.events.AccessingConsoleInput;

public class AccessingConsoleInputSource {
    AccessingConsoleInput accessingConsoleInput;

    public AccessingConsoleInputSource(AccessingConsoleInput accessingConsoleInput) {
        this.accessingConsoleInput = accessingConsoleInput;
    }

    public void generateEvent() {
        accessingConsoleInput.Handler();
    }
}
