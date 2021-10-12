package Zaur.Lesson27.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListEx1 {
    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Zaur");
        arrayList.add("Ivan");
        arrayList.add("Mariya");


        System.out.println(arrayList);

        ArrayList<String> arrayList2 = new ArrayList<>(200); // initial capacity
        arrayList2.add("Zaur");
        arrayList2.add("Ivan");
        List<String> arrayList3 = new ArrayList<>(); // initial capacity

        ArrayList<String> arrayList4 = new ArrayList<>(arrayList);
        System.out.println(arrayList4);
        System.out.println(arrayList4 == arrayList);
    }
}
class Car{}
