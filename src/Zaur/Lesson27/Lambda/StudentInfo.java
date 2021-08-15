package Zaur.Lesson27.Lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Function;

public class StudentInfo {
    //Второй параметр метода выводящего в консоль элементы соответствующие условиям лямбды-
    void testStudents(ArrayList<Student> a1, Predicate<Student> pr) {
        for (Student s : a1) {
            if (pr.test(s)) {
                System.out.println(s);
            }
        }
    }

//    void printStudensOverGrade(ArrayList<Student> a1, double grade) {
//        for (Student s : a1) {
//            if (s.averGrade > grade) {
//                System.out.println(s);
//            }
//        }
//    }
//
//    void printStudentsUnderAge(ArrayList<Student> a1, int age) {
//        for (Student s : a1) {
//            if (s.age < age) {
//                System.out.println(s);
//            }
//        }
//    }
//
//    void printStudentsMixCondition(ArrayList<Student> a1, int age, double grade, char sex) {
//        for (Student s : a1) {
//            if (s.age > age && s.averGrade < grade && s.sex == sex) {
//                System.out.println(s);
//            }
//        }
//    }
}

class Test {
    public static void main(String[] args) {
        Student st1 = new Student("ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elenq", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Mariya", 'f', 23, 3, 7.4);

        ArrayList<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        StudentInfo info = new StudentInfo();
//        Collections.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student s1, Student s2) {
//                return s1.course - s2.course;
//            }
//        });
//        Collections.sort(students, Comparator.comparingInt(s -> s.age));
//        System.out.println(students);
//        info.testStudents(students, new CheckOverGrade());
//        System.out.println("================");
//        info.testStudents(students, new StudentCheks() {
//            @Override
//            public boolean check(Student s) {
//                return s.age < 30;
//            }
//        });
//        info.testStudents(students, (Student s) -> {
//            return s.averGrade > 8;
//        });
//        //самый короткий способ написания  лямбда-выражения
//        info.testStudents(students, p -> p.averGrade > 8);

//        Predicate<Student> p1 = student -> student.averGrade > 7.5;
//        Predicate<Student> p2 = student -> student.sex == 'm';
//
//        info.testStudents(students, p1.negate());
//
//        System.out.println("================");
//        info.testStudents(students, (Student s) -> {
//            System.out.println("Hello!");
//            return s.age < 30;
//        });
//        System.out.println("================");
//        info.testStudents(students, s -> (s.age > 20 && s.averGrade < 9.3 && s.sex == 'f'));
/*
        info.printStudensOverGrade(students, 8);
        System.out.println("================================");
        info.printStudentsUnderAge(students, 30);
        System.out.println("=====================================");
        info.printStudentsMixCondition(students, 20, 9.5, 'f');
*/

        Function<Student, Double> f = student -> student.averGrade;
        //вызываем метод  принимаем list описываем функцию метод apply()
        double res = averageOfAny(students, student -> (double) student.age);
        System.out.println(res);

    }

    // принимает st    возвращает apply()
    private static double averageOfAny(List<Student> list, Function<Student, Double> function) {
        double result = 0;
        for (Student st : list) {
            // у функц. интерфейса  есть метод apply()
            result += function.apply(st);
        }
        result = result / list.size();
        return result;
    }
}
// Это функциональный интерфейс, имеющий один абстрактный метод
//interface StudentCheks {
//    boolean check(Student s);  // который возвращает boolean
//}

//class CheckOverGrade implements StudentCheks {
//
//    @Override
//    public boolean check(Student s) {
//        return s.averGrade > 8;
//    }
//}