package lab2;

public class Main implements ThrowBiggerThanAnotherException, SearchForNumbers{
    public static void main(String[] args) {
        //номера исключительных ситуаций 10.  000011100
        //исключения: 3. Больше, чем некоторое число
        //            4. В массиве число элементов больше указанного
        //            5. Меньше, чем некоторое число

    }

    @Override
    public void ThrowBiggerThanAnotherException() throws BiggerThanAnotherNumber {

    }

    @Override
    public void ThrowArrayContainsMoreElementsThanSpecified() throws ArrayContainsMoreElementsThanSpecified {

    }

    @Override
    public void ThrowLesserThanAnother() throws LesserThanAnother {

    }

    @Override
    public void getResultOfSearch(String[] args) {
        int evenPositiveNumbers = 0; //четные и положительные
        int oddAndNegative = 0; //нечетные и положительные

        System.out.print("Наши числа подаваемые через аргументы args: ");
        for (String argument : args) {
            System.out.print(argument + " ");
            if (Integer.parseInt(argument) > 0 && Integer.parseInt(argument) % 2 == 0)
                evenPositiveNumbers++;
            else if (Integer.parseInt(argument) < 0 && Integer.parseInt(argument) % 2 != 0)
                oddAndNegative++;
        }
        if (evenPositiveNumbers > oddAndNegative)
            System.out.printf("\nЧетных и положительных числе(%s) больше чем нечетных и отрицательных(%s)\n", evenPositiveNumbers, oddAndNegative);
        else if (evenPositiveNumbers < oddAndNegative)
            System.out.printf("Четных и положительных числе(%s) меньше чем нечетных и отрицательных(%s)\n", evenPositiveNumbers, oddAndNegative);
        else
            System.out.printf("Четных и положительных числе(%s) меньше столько же сколько и нечетных и отрицательных(%s)", evenPositiveNumbers, oddAndNegative);

    }

}

