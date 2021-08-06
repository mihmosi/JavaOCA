package JmProjects.Generics;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.BiFunction;

import static java.lang.Long.sum;

public class Task_6_2_15_Map {
    public static Map<String, Long> getSalesMap(Reader reader) {
        Map<String, Long> entry = new HashMap<>();
        try (Scanner scan = new Scanner(reader)) {
            while (scan.hasNext())
                entry.merge(scan.next(), scan.nextLong(), Long::sum);
        } catch (NoSuchElementException e) {
            e.getStackTrace();
        }
        return entry;
    }

    public static void main(String[] args) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream("Алексей 3000\nДмитрий 9000\nАнтон 3000\nАлексей 7000\nАнтон 8000".getBytes());
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(bais));
        System.out.println(getSalesMap(buffReader));
    }
}
