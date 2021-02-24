package lab2;

interface MyExceptions {
    void ThrowBiggerThanAnotherException() throws BiggerThanAnotherNumber;

    void ThrowArrayContainsMoreElementsThanSpecified() throws ArrayContainsMoreElementsThanSpecified;

    void ThrowLesserThanAnother() throws LesserThanAnother;
}
