package main;

import java.util.ArrayList;

// 10 variant - 100110;     1   0   0   1   10
/*
    Программный код вычисляемой функции разместить:
    1 – в классе Bean-компоненты.

    Заголовки страниц должны иметь следующий вид: 0 – «Стартовая страница»,
    «Главная страница» и «Финишная страница».

    Формат «Стартовой страницы»: 0 – содержит текст задания на лабораторную работу,
    ФИО студента и ссылку для перехода на «Главную страницу».

    Организовать вывод результатов работы функции на «Финишной странице»: 1 – результаты должны быть каким-то
    образом размещены в видимой таблице, в таблице допускается произвольное число
    столбцов и строк.

    При повторном переходе на «Главную страницу», например при нажатии кнопки
    «Возврат» на «Финишной странице», на «Главной странице» должно отображаться:
    2 – изменение счётчика, размещённого в Bean-компоненте.

    +++++++++++++
    Вариант 4 число 12 = 001100

5. Программный код вычисляемой функции разместить: 0 - на «Главной странице»

6. Заголовки страниц должны иметь следующий вид: 0 – «Стартовая страница», «Главная страница» и «Финишная страница»

7. Формат «Стартовой страницы»: 1 – содержит текст задания на лабораторную работу, группа студента и ссылку для перехода на «Главную страницу».

8. Организовать вывод результатов работы функции на «Финишной странице»: 1 – результаты должны быть каким-то образом размещены в таблице, в таблице допускается произвольное число столбцов и строк.

9. При повторном переходе на «Главную страницу», например при нажатии кнопки «Возврат» на «Финишной странице», на «Главной странице» должно отображаться: 0 – изменение триггера, размещённого в Bean-компоненте;
 */
public class MainClass {
    private final ArrayList<Integer> mainArray = new ArrayList<>();
    private final ArrayList<Integer> evenAndPositiveArray = new ArrayList<>();
    private final ArrayList<Integer> oddAndNegativeArray = new ArrayList<>();
    private int sumOfEvenAndPositive = 0;
    private int sumOfOddAndNegative = 0;
    private int count = 0;

    public boolean isOdd(int x){
        return x % 2 == 0;
    }

    public void prepareArr (MainClass obj, String arg){
        if (!arg.equals("")) {
            String[] arr = arg.split(" ");
            int inx;
            for (String item: arr){
                inx = Integer.parseInt(item);
                if (isOdd(inx) && inx > 0){
                    obj.addToEvenPositiveArray(inx);
                    obj.increaseSumEvenPositive(inx);
                } else if (!isOdd(inx) && inx < 0) {
                    obj.addToOddNegativeArray(inx);
                    obj.increaseSumOddNegative(inx);
                }
                obj.addToMainArray(inx);
            }
        }
    }

    public void addToMainArray(int item){
        this.mainArray.add(item);
    }

    public void addToEvenPositiveArray(int item){
        this.evenAndPositiveArray.add(item);
    }

    public void addToOddNegativeArray(int item){
        this.oddAndNegativeArray.add(item);
    }

    public String getMainArray() {
        StringBuilder arr = new StringBuilder();
        for (int item: mainArray){
            arr.append(item).append(" ");
        }
        return arr.toString();
    }

    public String getEvenAndPositiveArray() {
        StringBuilder arr = new StringBuilder();
        for (int item: evenAndPositiveArray){
            arr.append(item).append(" ");
        }
        return arr.toString();
    }

    public String getOddAndNegativeArray() {
        StringBuilder arr = new StringBuilder();
        for (int item: oddAndNegativeArray){
            arr.append(item).append(" ");
        }
        return arr.toString();
    }

    public int getSumOfEvenAndPositive(){
        return sumOfEvenAndPositive;
    }

    public void increaseSumEvenPositive(int value) {
        this.sumOfEvenAndPositive += value;
    }

    public int getSumOfOddAndNegative(){
        return sumOfOddAndNegative;
    }

    public void increaseSumOddNegative(int value) {
        this.sumOfOddAndNegative += value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increaseCount() {
        this.count++;
    }

    public void clear(){
        this.evenAndPositiveArray.clear();
        this.oddAndNegativeArray.clear();
        this.mainArray.clear();
        this.sumOfEvenAndPositive = 0;
        this.sumOfOddAndNegative = 0;
    }
}
