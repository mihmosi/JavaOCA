package Zaur.Lesson27;

import java.io.*;

public class Test8 {
    static StringBuilder abc() {
        StringBuilder a = new StringBuilder("Privet");
        try {
            File f = new File("test91.txt");
            FileInputStream fis = new FileInputStream(f);

        } catch (FileNotFoundException e) {
            System.out.println("Exception Poiman");
            System.out.println("Peremennaya a v catch bloke "+ a);
            return a;
        } finally {
            a.append("!!!");
            System.out.println("Eto block finally");
            System.out.println("Peremennaya a v finally bloke "+ a);
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(abc());
    }
}
