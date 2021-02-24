package lab2;

class ArrayContainsMoreElementsThanSpecified extends Exception {
    @Override
    public String toString() {
        return "Ошибка: В массиве число элементов больше указанного";
    }
}
