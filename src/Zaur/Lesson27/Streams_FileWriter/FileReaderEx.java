package Zaur.Lesson27.Streams_FileWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderEx {
    public static void main(String[] args) throws IOException {
//        FileReader reader = null;
        String a = "hOcket";
        try (FileReader reader = new FileReader("test1.txt");
             FileWriter writer = new FileWriter("test1.txt",true)) {
//            reader = ;
            writer.write("\n"+a);
            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }
            System.out.println();
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
