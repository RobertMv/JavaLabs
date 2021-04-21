package lab3;

import lab3.receivers.AccessingConsoleInputReceiver;
import lab3.receivers.ChangingVariableReceiver;
import lab3.receivers.EqualityOfTwoElementsReceiver;
import lab3.sources.AccessingConsoleInputSource;
import lab3.sources.ChangingVariableSource;
import lab3.sources.EqualityOfTwoElementsSource;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Util {
    // 000011100; указание пути к файлу "журнал" - 1(путь задается из файла);
    // способ реализации событий - 0(явная реализация событий)

    //3. Равенство указанного объекта некоторому значению
    //4. Обращение к потоку ввода с консоли
    //5. Изменение указанной переменной

    private final int NUMBER_TO_EQUAL_TO = 11;
    private final AccessingConsoleInputReceiver accessingReceiver = new AccessingConsoleInputReceiver();
    private final AccessingConsoleInputSource accessingSource = new AccessingConsoleInputSource(accessingReceiver);
    private final ChangingVariableReceiver changingReceiver = new ChangingVariableReceiver();
    private final ChangingVariableSource changingSource = new ChangingVariableSource(changingReceiver);
    private final EqualityOfTwoElementsReceiver equalityReceiver = new EqualityOfTwoElementsReceiver();
    private final EqualityOfTwoElementsSource equalitySource = new EqualityOfTwoElementsSource(equalityReceiver);
    public String[] args;
    Scanner sc = new Scanner(System.in);
    private String journalPath;

    public void getDataFromFile() throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        System.out.print("Enter main file path: ");
        String filePath = sc.nextLine(); //получили путь к основному файлу из консоли, в этом файле лежит путь к файлу журнала и необходимые данные

        accessingSource.generateEvent();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String l = reader.readLine();
            while (l != null) {
                lines.add(l);
                l = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        journalPath = lines.get(0);
        log(accessingReceiver.getMessage());
        args = lines.subList(1, lines.size()).toArray(new String[0]);
    }

    public void start() throws IOException {
        args[1] = "1810";
        changingSource.generateEvent();
        log(changingReceiver.getMessage());

        int evenPositiveNumbers = 0; //четные и положительные
        int oddAndPositive = 0; //нечетные и положительные

        System.out.print("Наши числа подаваемые через аргументы args: ");
        boolean isEqual = false;
        Integer equaledValue = null;
        for (String argument : args) {
            System.out.print(argument + " ");
            if (Integer.parseInt(argument) == NUMBER_TO_EQUAL_TO)
                isEqual = true;

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

        if (isEqual) {
            equalitySource.generateEvent();
            System.out.print(" " + equaledValue + " == " + NUMBER_TO_EQUAL_TO);
            log(equalityReceiver.getMessage());
        }

    }

    public void log(String str) throws IOException {
        try (FileWriter writer = new FileWriter(journalPath, true); BufferedWriter bw = new BufferedWriter(writer)) {
            bw.write(str);
            bw.newLine();
            bw.flush();
        }
    }
}
