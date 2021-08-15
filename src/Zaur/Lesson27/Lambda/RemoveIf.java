package Zaur.Lesson27.Lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

public class RemoveIf {
    public static void main(String[] args) {
        ArrayList<String> a1 = new ArrayList<>();
        a1.add("Privet");
        a1.add("Poka");
        a1.add("Ok");
        a1.add("uchim Java");
        a1.add("A imenno Lambda");
//        a1.removeIf(element->element.length()<5);
        Predicate<String> p = element -> element.length() < 5;
        a1.removeIf(p);
        System.out.println(a1);
    }
}
