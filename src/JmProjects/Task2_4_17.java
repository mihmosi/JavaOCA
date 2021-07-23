package day0.JmProjects;

public class Task2_4_17 {
    public static void main(String[] args) {
        int[] arr = {};
        printOddNumbers(arr);
    }

    public static void printOddNumbers(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int j : arr) {
            if (j % 2 != 0) {
                stringBuilder.append(j).append(",");
            }
        }
        if (stringBuilder.length() != 0) {
            System.out.println(stringBuilder.deleteCharAt(stringBuilder.length() - 1));
        }
    }
}

