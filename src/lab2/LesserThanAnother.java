package lab2;

class LesserThanAnother extends Exception {
    @Override
    public String toString() {
        return "Ошибка: Меньше, чем некоторое число";
    }
}
