package Zaur.Lesson27.collections;

import java.util.ArrayList;

public class ArraylistMethods1 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Zaur"); // adding  new element
        arrayList.add("Ivan");
        arrayList.add("Mariya");
        arrayList.add(1, "Misha");
// to print all elements
        for (String s : arrayList) {
            System.out.print(s + " ");
        }
        System.out.println(arrayList.size());

        // get
//        ArrayList<Integer> arrayList2 = new ArrayList<>();
//        arrayList2.add(6);
//        System.out.println(arrayList.get(2));

//        for (int i = 0; i < arrayList.size(); i++) {
//            System.out.println(arrayList.get(i));
//        }
        //set
        arrayList.set(1, "Masha");
        arrayList.remove(0);

        System.out.println(arrayList);

    }
}
