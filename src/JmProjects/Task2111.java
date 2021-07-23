package day0.JmProjects;

public class Task2111 {
    public static void main(String[] args) {
        int sum;

        sum = drawisMonitorsCounter(12, 5);
        System.out.println(sum);
        double x = 0x0bp3;

        System.out.println(x);
    }

    public static int drawisMonitorsCounter(int monitors, int programmers) {
        return monitors % programmers;
    }
}
