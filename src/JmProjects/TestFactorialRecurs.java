package day0.JmProjects;

import java.math.BigInteger;

public class TestFactorialRecurs {
    public static void main(String[] args) {
        System.out.println(factorial(0));
    }

    public static BigInteger factorial(int value) {
        BigInteger result = BigInteger.ONE;
        if (value == 1 || value == 0) {
            return result;
        }
        result = BigInteger.valueOf(value).multiply(factorial(value - 1));
        return result;
    }
}
