package JmProjects;

import java.io.*;

public class Task5_2_7 {
    public static void main(String[] args) throws Exception {
        byte[] input = {-1, 1, 2, 4, 10, -4};
        InputStream inputStream = new ByteArrayInputStream(input);
        int result = sumOfStream(inputStream);
        OutputStream outputStream = new ByteArrayOutputStream();
        System.out.println(result);
        print(inputStream, outputStream);
        System.out.println(inputStream);
//        System.out.println(result2);
    }

    public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {
        int buff;
        while ((buff = inputStream.read()) != -1) {
            if (buff % 2 == 0){
                outputStream.write(buff);
                outputStream.flush();
            }
        }
    }

    public static int sumOfStream(InputStream inputStream) throws IOException {
        int buff;
        int sum = 0;
        while ((buff = inputStream.read()) != -1) {
            sum += (byte) buff;
        }
        return sum;
    }
}

