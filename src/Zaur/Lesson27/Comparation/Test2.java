package Zaur.Lesson27.Comparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {


        List<Employee> list = new ArrayList<>();
        Employee empl1 = new Employee(100, "Zaur", "Tregulov", 50);
        Employee empl2 = new Employee(15, "Ivan", "Fedorov", 100);
        Employee empl3 = new Employee(123, "Ivan", "Sidorov", 80);
        list.add(empl1);
        list.add(empl2);
        list.add(empl3);
        System.out.println("Before sorting\n" + list);
        Collections.sort(list, new SalaryCpmparator());
        System.out.println("After sorting\n" + list);
    }
}

class Employee
        implements Comparable<Employee> {
    protected int id;
    protected String name;
    protected String surname;
    protected int salary;

    public Employee(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Employee{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", salary=").append(salary);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Employee enotherEmployee) {
        if (this.id == enotherEmployee.id) {
            return 0;
        } else if (this.id < enotherEmployee.id) {
            return -1;
        } else {
            return 1;
        }
////        return this.id - enotherEmployee.id; //если this < enother == -1 если  рввны  то  0
////        return this.id.compareTo(enotherEmployee.id);
////        int res = this.name.compareTo(enotherEmployee.name);
////        if (res == 0) {
////            res = this.surname.compareTo(enotherEmployee.surname);
////        }
////        return res;

    }


}

//class IdCpmparator implements Comparator<Employee> {
//
//    @Override
//    public int compare(Employee emp1, Employee emp2) {
//        if (emp1.id == emp2.id) {
//            return 0;
//        } else if (emp1.id < emp2.id) {
//            return -1;
//        } else {
//            return 1;
//        }
//    }
//}

class NameCpmparator implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.name.compareTo(emp2.name);
    }
}

class SalaryCpmparator implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.salary - (emp2.salary);
    }
}