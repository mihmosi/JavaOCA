package Zaur.Lesson27.Streams_FileWriter;

import java.io.*;

public class CopyEx {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(       /** создаем объект и оборачиаем им ридер  */
                new FileReader("test1.txt"));
            BufferedWriter writer = new BufferedWriter(           /** создаем объект врайтера  */
                    new FileWriter("test3.txt"))) {
//            int character;                               /** сам буфер  */
//            while ((character=reader.read()) != -1){
//                writer.write(character);                 /** пишем прочитанное сразу в файл  */
//            }
            String line;
            while ((line= reader.readLine()) != null){
                writer.write(line);
                writer.write("\n");
            }
            System.out.println("Done!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
