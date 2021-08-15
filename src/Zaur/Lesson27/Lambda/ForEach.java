package Zaur.Lesson27.Lambda;

import java.util.ArrayList;
import java.util.List;

public class ForEach {
    public static void main(String[] args) {


        List<String> list = List.of("privet", "kak dela", "normalno", "poka");
        for (String s : list) {
            System.out.println(s);
        }
//        list.forEach(str-> System.out.println(str));
        List<Integer> listInt = new ArrayList<>();
        listInt.add(1);
        listInt.add(2);
        listInt.add(3);
        listInt.add(4);
        listInt.add(5);
        listInt.forEach(e1 -> {
                    System.out.println(e1);
                    e1 *= 2;
                    System.out.println(e1);
                }
        );
    }
    // прарвался на   5.58 Лямбда 5
}
