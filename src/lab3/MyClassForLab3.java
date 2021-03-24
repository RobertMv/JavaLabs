package lab3;

import java.util.Scanner;

public class MyClassForLab3 {
    // 000011100; указание пути к файлу "журнал" - 1(путь задается из файла);
    // способ реализации событий - 0(явная реализация событий)
    //3. Равенство указанного объекта некоторому значению
    //4. Обращение к потоку ввода с консоли
    //5. Изменение указанной переменной

    Scanner sc = new Scanner(System.in);
    String inputWay = sc.nextLine(); // 'file' or 'console'
    String journalFilePath;
    String filePath;

    public void start() {
        System.out.print("Enter main file path: ");
        filePath = sc.nextLine(); //получили путь в основному файлу из консоли, в этом файле лежит путь к файлу журнала и необходимые данные


    }

    public void input(String filePath) {

    }

    public void input() {

    }

}
