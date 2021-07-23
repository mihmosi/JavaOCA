package day0.JmProjects;

/**
 * Напишите метод evenArray который принимает целое число типа int
 * и возвращает массив заполненный четными числами от 1 до этого числа.
 * Пример ввода: 8
 * Пример вывода: [2,4,6,8]
 * Требования:
 * 1. Метод должен быть публичным.
 * 2. Параметр должен иметь тип int.
 * 3. Сигнатура метода должна быть: evenArray(int number)
 */
public class Task2_4_16 {
    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(evenArray(8)));
    }

    public static int[] evenArray(int number) {
        int[] result = new int[number / 2];
        int j = 0;
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                result[j] = i;
                j++;
            }
        }
        return result;
    }
}

