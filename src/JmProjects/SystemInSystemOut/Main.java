package JmProjects.SystemInSystemOut;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Напишите программу, читающую текст из System.in и выводящую в System.out
 * сумму всех встреченных в тексте вещественных чисел с точностью до шестого
 * знака после запятой. Числом считается последовательность символов,
 * отделенная от окружающего текста пробелами или переводами строк и успешно
 * разбираемая методом Double.parseDouble.
 * На этот раз вам надо написать программу полностью, т.е. объявить класс
 * (с именем Main — таково ограничение проверяющей системы), метод main, прописать все import'ы
 */
public class Main {
    public static void main(String[] args) {
        double sum = 0.0;
        Scanner sc = new Scanner(System.in);

        try {
            while (sc.hasNext()) {
                if (sc.hasNextDouble()) {
                    sum += Double.parseDouble(sc.next());
                } else {
                    sc.next();
                }

            }
        } catch (NumberFormatException e) {
        } finally {
            sc.close();
        }
        System.out.printf("%.6f", sum);
    }
}
