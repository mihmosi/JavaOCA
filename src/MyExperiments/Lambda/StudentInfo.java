package MyExperiments.Lambda;

import java.util.ArrayList;

public class StudentInfo {

    //метод принимает массив и объект интерфейса sc с методом check
    void testStudent(ArrayList<Student> al, StudentCheks sc){
        for (Student s: al){
            if (sc.check(s)){
                System.out.println(s);
            }
        }
    }


//    void ptintStudetnOverGrade(ArrayList<Student> al, double grade) {
//        for (Student s : al) {
//            if (s.aveGrade > grade) {
//                System.out.println(s);
//            }
//        }
//    }
//
//    void ptintStudetnUndrAge(ArrayList<Student> al, int age) {
//        for (Student s : al) {
//            if (s.age < age) {
//                System.out.println(s);
//            }
//        }
//    }
//
//    void ptintStudetsMixCondition(ArrayList<Student> al, int age, double grade, char sex) {
//        for (Student s : al) {
//            if (s.age > age && s.aveGrade < grade && s.sex == sex) {
//                System.out.println(s);
//            }
//        }

//    }
}
class Test{
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'M', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'M', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'F', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'M', 35, 4, 7);
        Student st5 = new Student("Mariya", 'F', 23, 3, 9.1);
        ArrayList<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        StudentInfo info = new StudentInfo();
        info.testStudent(students, new CheckOverGrade());
        System.out.println("------------------------------");
        info.testStudent(students, new StudentCheks() {
            @Override
            public boolean check(Student s) {
                return s.age< 30;
            }
        });
        System.out.println("------------------------------");
        info.testStudent(students, (Student s) -> { return s.age< 30; });
//        info.ptintStudetnOverGrade(students, 8);
//        System.out.println("-----------------------------------------------");
//        info.ptintStudetnUndrAge(students, 30);
//        System.out.println("-----------------------------------------------");
//        info.ptintStudetsMixCondition(students, 20, 9.5, 'F');

    }
}
interface StudentCheks{
    boolean check(Student s);
}
class CheckOverGrade implements StudentCheks{
    @Override
    public boolean check(Student s) {
        return s.aveGrade>8;
    }
}