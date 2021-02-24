package lab2;

class BiggerThanAnotherNumber extends Exception {
    @Override
    public String toString() {
        return "Ошибка: Больше, чем некоторое число";
    }
}
