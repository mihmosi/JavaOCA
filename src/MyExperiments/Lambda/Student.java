package MyExperiments.Lambda;

public class Student {
    String name;
    char sex;
    int age;
    int course;
    double aveGrade;

    public Student(String name, char sex, int age, int course, double aveGrade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.aveGrade = aveGrade;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("name=' ").append(name).append('\'');
        sb.append(", sex= ").append(sex);
        sb.append(", age= ").append(age);
        sb.append(", course= ").append(course);
        sb.append(", aveGrade= ").append(aveGrade);
        sb.append('}');
        return sb.toString();
    }
}
