package Zaur.Lesson27.Lambda;

public class Test2 {
    static void def(I i) {
        System.out.println(i.abc("Privet"));
    }

    public static void main(String[] args) {
        final int i = 10;
//        i = 15; изменять нельзя
        def((String str) -> {
            int a = 5;
            System.out.println(i);
            return str.length() + i;
        });

    }
}

interface I {
    int abc(String s);
}