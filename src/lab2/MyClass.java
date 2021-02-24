package lab2;

public class MyClass implements MyExceptions, SearchForNumbers{
    //номера исключительных ситуаций 10.  000011100
    //исключения: 3. Больше, чем некоторое число
    //            4. В массиве число элементов больше указанного
    //            5. Меньше, чем некоторое число

    public final int MAX_NUMBER;
    public final int MIN_NUMBER;
    public final int LENGTH;

    public MyClass(int max_number, int min_number, int length) {
        MAX_NUMBER = max_number;
        MIN_NUMBER = min_number;
        LENGTH = length;
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
            //обработка ошибок
            if(Integer.parseInt(argument) > MAX_NUMBER) try {
                throw new BiggerThanAnotherNumber();
            } catch (BiggerThanAnotherNumber biggerThanAnotherNumber) {
                biggerThanAnotherNumber.printStackTrace();
            }
            if(Integer.parseInt(argument) < MIN_NUMBER) try {
                throw new LesserThanAnother();
            } catch (LesserThanAnother lesserThanAnother) {
                lesserThanAnother.printStackTrace();
            }
            if (args.length > LENGTH) try {
                throw new ArrayContainsMoreElementsThanSpecified();
            } catch (ArrayContainsMoreElementsThanSpecified arrayContainsMoreElementsThanSpecified) {
                arrayContainsMoreElementsThanSpecified.printStackTrace();
                break;
            }
            //
            System.out.print(argument + " ");
            if (Integer.parseInt(argument) > 0 && Integer.parseInt(argument) % 2 == 0)
                evenPositiveNumbers++;
            else if (Integer.parseInt(argument) < 0 && Integer.parseInt(argument) % 2 != 0)
                oddAndNegative++;
        }
        if (evenPositiveNumbers > oddAndNegative)
            System.out.printf("\nЧетных и положительных чисел(%s) больше чем нечетных и отрицательных(%s)\n", evenPositiveNumbers, oddAndNegative);
        else if (evenPositiveNumbers < oddAndNegative)
            System.out.printf("Четных и положительных чисел(%s) меньше чем нечетных и отрицательных(%s)\n", evenPositiveNumbers, oddAndNegative);
        else
            System.out.printf("Четных и положительных чисел(%s) меньше столько же сколько и нечетных и отрицательных(%s)", evenPositiveNumbers, oddAndNegative);

    }
}
