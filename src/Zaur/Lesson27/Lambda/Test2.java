package Zaur.Lesson27.Lambda;

public class Test2 {
    static void def(I i) {
        System.out.println(i.abc("Privet"));
    }

    public static void main(String[] args) {
        def((String str) -> {
            return str.length();
        });
    }
}

interface I {
    int abc(String s);
}