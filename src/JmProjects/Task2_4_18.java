package day0.JmProjects;

import java.util.Arrays;

/**
 * Реализуйте метод, сливающий два отсортированных по неубыванию массива чисел в один
 * отсортированный в том же порядке массив. Массивы могут быть любой длины, в том числе нулевой.
 * <p>
 * Предполагается, что вы реализуете алгоритм слияния, имеющий линейную сложность:
 * он будет идти по двум исходным массивам и сразу формировать отсортированный результирующий массив.
 * Так, чтобы сортировка полученного массива при помощи Arrays.sort() уже не требовалась.
 * <p>
 * К сожалению, автоматически это не проверить, так что это остается на вашей совести :)
 * <p>
 * Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку
 * ввода-вывода добавит проверяющая система.
 * <p>
 * Пример ввода: {0, 2, 2} и {1, 3}
 * Пример вывода: {0, 1, 2, 2, 3}
 */
public class Task2_4_18 {
    public static void main(String[] args) {
        int[] arr1 = {0, 2, 2};
        int[] arr2 = {2, 3, 3, 8};

        System.out.println(Arrays.toString(mergeArrays(arr1, arr2)));
    }

    public static int[] mergeArrays(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        int firstCount = 0;
        int secondCount = 0;
        for (int countResult = 0; countResult < result.length; countResult++) {
            if (firstCount >= a1.length) {
                result[countResult] = a2[secondCount];
                secondCount++;
            } else if (secondCount >= a2.length) {
                result[countResult] = a1[firstCount];
                firstCount++;
            } else if (a1[firstCount] <= a2[secondCount]) {
                result[countResult] = a1[firstCount];
                firstCount++;
            } else if (a2[secondCount] <= a1[firstCount]) {
                result[countResult] = a2[secondCount];
                secondCount++;
            }
        }
        return result;
    }
}
