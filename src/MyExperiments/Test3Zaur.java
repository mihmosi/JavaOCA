package MyExperiments;

import java.util.ArrayList;
import java.util.List;

public class Test3Zaur {
    public static void main(String[] args) {
        List<?> list = new ArrayList<String>();
//        list.add("privet");  нельзя изменять объект!!!

        List<? extends Number> list33 = new ArrayList<Integer>();

        List<Double> list1 = new ArrayList<>();
        list1.add(3.14);
        list1.add(3.15);
        list1.add(3.16);
        List<String> list2 = new ArrayList<>();
        list2.add("ok");
        list2.add("privet");
        list2.add("Poka");

        ArrayList<Double> arlist = new ArrayList<>();
        arlist.add(3.14);
        arlist.add(3.15);
        arlist.add(3.16);
        System.out.println(summ(arlist));

        ArrayList<Integer> arlistInyt = new ArrayList<>();
        arlistInyt.add(3);
        arlistInyt.add(30);
        arlistInyt.add(35);
        System.out.println(summ(arlistInyt));


        showListTyoe(list1);
        showListTyoe(list2);
    }

    static void showListTyoe(List<?> list) {
        System.out.println("Moi list imeet sleduushie elementy: " + list);
    }

    public static double summ(ArrayList<? extends Number> arl) {
        double sum = 0;
        for (Number n : arl) {
            sum += n.doubleValue();
        }
        return sum;
    }
}
