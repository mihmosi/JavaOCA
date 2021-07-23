package Zaur.Lesson27;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Test9 {
    void abc() throws FileNotFoundException {
        try {
            File f = new File("test91.txt");
            FileInputStream fis = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            System.out.println("Exception Poiman i nemnogo obrabotan");
            throw e;
        } finally {
            System.out.println("Eto block finally");
        }
    }

    void method() {
        try {
            abc();
        } catch (FileNotFoundException e) {
            System.out.println("Exception Poiman i polnostyu obrabotan");
        }
    }
}
