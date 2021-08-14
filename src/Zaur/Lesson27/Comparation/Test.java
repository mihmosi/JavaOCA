package Zaur.Lesson27.Comparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Zaur");
        list.add("Ivan");
        list.add("Mariya");
        System.out.println("Pered sortirovkoy\n "+list);
        Collections.sort(list);
        System.out.println("Posle sortirovki \n" +list);
    }
}
