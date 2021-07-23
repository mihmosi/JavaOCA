package Zaur.Lesson27;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test7 {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder("");
        try {
            File f = new File("test9.txt");
            System.out.println("Obyect sozdalsya");
            FileInputStream fis = new FileInputStream(f);
            System.out.println("Strim sozdalsya");
            int counter = 0;
            while (true) {
                counter++;
                result.append(fis.read());
                System.out.println("Informaciya chitaetsya");
                if (counter == 3){
                    fis.close();
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Exception 1"+ e);

        } catch (IOException a) {
            System.out.println("Exception 2"+ a);
        } finally {
            System.out.println("Eto finally");
            System.out.println(result);
        }
    }
}
