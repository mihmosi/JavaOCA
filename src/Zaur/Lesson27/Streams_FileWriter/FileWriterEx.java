package Zaur.Lesson27.Streams_FileWriter;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEx {
    public static void main(String[] args) throws IOException {
        String rubai = "Много лет размышлял я над жизнью земной.\n" +
                "Непонятного нет для меня под луной.\n" +
                "Мне известно, что мне ничего неизвестно!\n" +
                "Вот последняя правда открытая мной.\n";
        String s = "privet\n";

        try (FileWriter writer = new FileWriter("test0.txt", true)) {
//        for (int i = 0;i < rubai.length();i++){
//            writer.write(rubai.charAt(i));
//        }
            writer.write(rubai);
            writer.write(s);
            System.out.println("Done!");
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
