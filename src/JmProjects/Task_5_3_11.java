package JmProjects;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Реализуйте метод, который зачитает данные из InputStream и преобразует
 * их в строку, используя заданную кодировку.
 * Пример
 * InputStream последовательно возвращает четыре байта: 48 49 50 51.
 * Метод, вызванный для такого InputStream и кодировки ASCII, должен вернуть
 * строку "0123".
 */

public class Task_5_3_11 {
    public static void main(String[] args) throws Exception {
        byte[] input = {48, 49, 50, 51};
        InputStream inputStream = new ByteArrayInputStream(input);
        System.out.println(readAsString(inputStream, StandardCharsets.US_ASCII));
    }

    public static String readAsString(InputStream inputStream,
                                      Charset charset) throws IOException {
        int buff = 0;
        String s = "";
        StringBuilder sb = new StringBuilder();
        /** str это поток байт соответствующих символам, inputStream это поток байтов*/
        InputStreamReader str = new InputStreamReader(inputStream, charset);
        while ((buff = str.read()) != -1) {
            s = sb.append((char)buff).toString();
        }
        return s;
    }

}

//    public static int sumOfStream(InputStream inputStream) throws IOException {
//        int buff;
//        int sum = 0;
//        while ((buff = inputStream.read()) != -1) {
//            sum += (byte) buff;
//        }
//        return sum;
//    }

