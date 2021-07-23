package day0.JmProjects;

import java.math.BigInteger;

public class TestFactorial {
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }

    public static BigInteger factorial(int value) {
        BigInteger res = BigInteger.ONE;
        for (int i = 1; i <= value; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }
}
