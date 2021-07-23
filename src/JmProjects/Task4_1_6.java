package day0.JmProjects;

public class Task4_1_6 {
    public static void main(String[] args) {
        Cat a = new Cat();
        Dog dog = new Dog();
        a = (Cat) dog;  // java.lang.ClassCastException
    }
}

class Cat extends Dog {
    String name1 = "Boris";
}

class Dog {
    String name2 = "Muslim";
}
