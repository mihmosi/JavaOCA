package Zaur.Lesson27.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("privet");
        list.add("kak dela");
        list.add("poka");
        list.add("ok");

//        for (int i = 0;i< list.size();i++){
//            list.set(i, String.valueOf(list.get(i).length()));
//        }
        // 6  9  2  4
        List<Integer> list2 = list.stream().map(element -> element.length())
                .collect(Collectors.toList());
//        System.out.println(list2);

        int[] arr = {5, 9, 3, 8, 1};
        arr = Arrays.stream(arr).map(element
                -> {
            if (element % 3 == 0) {
                element = element / 3;
            }
            return element;
        }).toArray();
//        System.out.println(Arrays.toString(arr));
        Set<String> set = new TreeSet<>();
        set.add("privet");
        set.add("kak dela");
        set.add("poka");
        set.add("ok");
        System.out.println(set);
        List <Integer> list3 = set.stream().map(e->e.length()).collect(Collectors.toList());
        System.out.println(list3);
    }
}
