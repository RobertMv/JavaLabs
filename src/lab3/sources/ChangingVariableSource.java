package lab3.sources;

import lab3.events.ChangingVariable;

public class ChangingVariableSource {
    ChangingVariable changingVariable;

    public ChangingVariableSource(ChangingVariable changingVariable) {
        this.changingVariable = changingVariable;
    }

    public void generateEvent() {
        changingVariable.Handler();
    }
}
