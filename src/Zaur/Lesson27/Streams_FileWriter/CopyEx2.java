package Zaur.Lesson27.Streams_FileWriter;

import java.io.*;

public class CopyEx2 {
    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream("C:\\Users\\Mike\\Desktop\\unnamed.png");
             FileOutputStream outputStream = new FileOutputStream("unnamed.png")) {
            int i;
            while ((i = inputStream.read()) != -1) {
                outputStream.write(i);
            }
            System.out.println("Done!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
