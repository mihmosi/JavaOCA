package day0.JmProjects;

public class Task2_3_10 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Eva, Can I Stab Bats In A Cave?"));
        System.out.println(isPalindrome("Madam"));
        System.out.println(isPalindrome("Not a number"));

    }

    public static boolean isPalindrome(String text) {
        text = (text.replaceAll("[^a-zA-Z0-9]", ""));
        String str = new StringBuilder(text).reverse().toString();
        return str.equalsIgnoreCase(text);
    }
}
