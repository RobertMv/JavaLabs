package lab1;

public class Main {
    public static void main(String[] args) {
        int evenPositiveNumbers = 0; //четные и положительные
        int oddAndPositive = 0; //нечетные и положительные

        System.out.print("Наши числа подаваемые через аргументы args: ");
        for (String argument : args) {
            System.out.print(argument + " ");
            if (Integer.parseInt(argument) > 0 && Integer.parseInt(argument) % 2 == 0)
                evenPositiveNumbers++;
            else if (Integer.parseInt(argument) < 0 && Integer.parseInt(argument) % 2 != 0)
                oddAndPositive++;
        }
        if (evenPositiveNumbers > oddAndPositive)
            System.out.printf("\nЧетных и положительных числе(%s) больше чем нечетных и отрицательных(%s)\n", evenPositiveNumbers, oddAndPositive);
        else if (evenPositiveNumbers < oddAndPositive)
            System.out.printf("Четных и положительных числе(%s) меньше чем нечетных и отрицательных(%s)\n", evenPositiveNumbers, oddAndPositive);
        else
            System.out.printf("Четных и положительных числе(%s) меньше столько же сколько и нечетных и отрицательных(%s)", evenPositiveNumbers, oddAndPositive);

    }
}
