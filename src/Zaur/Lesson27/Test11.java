package Zaur.Lesson27;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test11 {
    FileInputStream fis1, fis2;

    public void abc() {
        try {
            fis1 = new FileInputStream("test9.txt");
            try {
                fis2 = new FileInputStream("test10.txt");
            } catch (FileNotFoundException e) {
                System.out.println("file test10 ne naiden");
            }
        } catch (FileNotFoundException e) {
            System.out.println("file test9 ne naiden");
        } finally {
            System.out.println("eto vneshniy block finally");
            try {
                fis1.close();
                fis2.close();
            } catch (IOException e) {
                System.out.println("Naydenny isclucheniya v finally bloke");
            }
        }
    }

    public static void main(String[] args) {
        Test11 t = new Test11();
        t.abc();
    }
}
