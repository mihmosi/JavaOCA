package day0.JmProjects;

import java.util.Arrays;

/**
 * Напишите статический класс AsciiCharSequence, реализующий компактное хранение
 * последовательности ASCII-символов (их коды влезают в один байт) в массиве байт.
 * По сравнению с классом String из Java 8, хранящим каждый символ как char,
 * AsciiCharSequence будет занимать в два раза меньше памяти
 * <p>
 * Класс AsciiCharSequence должен:
 * реализовывать интерфейс java.lang.CharSequence;
 * иметь конструктор, принимающий массив байт;
 * определять методы length(), charAt(), subSequence() и toString()
 * <p>
 * Сигнатуры методов и ожидания по их поведению смотрите в описании интерфейса
 * java.lang.CharSequence (JavaDoc или исходники).
 * <p>
 * В данном задании методам charAt() и subSequence() всегда будут подаваться корректные
 * входные параметры, поэтому их проверкой и обработкой ошибок заниматься не нужно.
 * Тем более мы еще не проходили исключения.
 */
public class Task3_5_6 {
    public static class AsciiCharSequence implements CharSequence {
        private byte[] arr;
        // Конструктор который описывает параметр объекта AsciiCharSequence. На вход мы подаем массив байтов
        public AsciiCharSequence(byte[] arr) {
            this.arr = arr.clone();
        }
        // методк который считает длину строки по длине массива
        @Override
        public int length() {
            return arr.length;
        }
        // метод который выбирает символ по счету
        @Override
        public char charAt(int index) {
            return (char) arr[index];
        }
        // метод который берет массив из объекта и выводит число символов с позиции
        @Override
        public CharSequence subSequence(int start, int end) {
            return new AsciiCharSequence(Arrays.copyOfRange(arr, start, end));
        }
        // метод который берет массив из объекта и перечисляет их конвертируя из байта в чар и состввляя строку
        public String toString() {
            return new String(arr, java.nio.charset.StandardCharsets.ISO_8859_1);
        }
    }

    public static void main(String[] args) {

        byte[] example = {72, 101, 108, 108, 111, 33};
        AsciiCharSequence answer = new AsciiCharSequence(example);
        System.out.println("Последовательность - " + answer.toString());//Hello!
        System.out.println("Размер её - " + answer.length());//6
        System.out.println("Символ под № 1 - " + answer.charAt(1));//e
        System.out.println("Подпоследовательность - " + answer.subSequence(1, 5));//ello
//проверка на нарушение инкапсуляции private поля
        System.out.println(answer.toString());//Hello!
        example[0] = 74;
        System.out.println(answer.toString());//Hello!
    }
}
