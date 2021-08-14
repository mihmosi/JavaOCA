package Zaur.Lesson27.Lambda;

public class Student {
    String name;
    char sex;
    int age;
    int course;
    double averGrade;

    public Student(String name, char sex, int age, int course, double averGrade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.averGrade = averGrade;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", course=").append(course);
        sb.append(", averGrade=").append(averGrade);
        sb.append('}');
        return sb.toString();
    }
}
