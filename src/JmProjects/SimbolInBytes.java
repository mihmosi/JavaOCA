package JmProjects;

import java.nio.charset.StandardCharsets;

public class SimbolInBytes {
    public static void main(String[] args) {
        char ch;
        ch = 'Ы';
        byte b = (byte) ch;
        System.out.println(b);
        System.out.println("Ы".getBytes(StandardCharsets.UTF_8)[1] & 0xFF);
        System.out.println(Integer.toBinaryString(208));
        System.out.println(Integer.toBinaryString(-48));
    }
}
