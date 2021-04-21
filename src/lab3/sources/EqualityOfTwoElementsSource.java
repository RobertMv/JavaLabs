package lab3.sources;

import lab3.events.EqualityOfTwoElements;

public class EqualityOfTwoElementsSource {
    EqualityOfTwoElements equalityOfTwoElements;

    public EqualityOfTwoElementsSource(EqualityOfTwoElements equalityOfTwoElements) {
        this.equalityOfTwoElements = equalityOfTwoElements;
    }

    public void generateEvent() {
        equalityOfTwoElements.Handler();
    }
}
