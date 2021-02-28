package com.reddit.r_dailyprogrammer_challenge;

import java.math.BigInteger;
import java.util.Arrays;

public class Ch384 {

    public static void main(String[] args) {
        System.out.println(uniquNecklaces(99, 2));
    }


    public static boolean isPrime(long number) {
        if (number < 1) {
            throw new IllegalArgumentException("number must be greater than 0");
        }

        if (number == 1 || number == 2 || number == 3) {
            return true;
        }

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static long phi(long number) {

        if (number < 1) {
            throw new IllegalArgumentException("number must be greater than 0");
        }

        if (number == 1 || number == 2) {
            return 1;
        }
        long[] primeDivisors = new long[0];

        for (int i = 2; i <= number; i++) {
            if (number % i == 0) {
                if (isPrime(i)) {
                    primeDivisors = Arrays.copyOf(primeDivisors, primeDivisors.length + 1);
                    primeDivisors[primeDivisors.length - 1] = i;
                }
            }
        }

        long dividend = number, divisor = 1;

        for (int i = 0; i < primeDivisors.length; i++) {
            dividend *= primeDivisors[i] - 1;
            divisor *= primeDivisors[i];
        }

        return dividend / divisor;

    }

    public static BigInteger uniquNecklaces(long k, long n) {

        if (k < 1 || n < 1) {
            throw new IllegalArgumentException("number of unique beads and length of the necklace must be greater than 0");
        }

        if (n == 1) {
            return BigInteger.valueOf(k);
        }

        BigInteger result = new BigInteger("1");

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                result = result.add(BigInteger.valueOf(phi(i) * (long) Math.pow(k, n / i)));
            }
        }

        result = result.add(BigInteger.valueOf(phi(n) * k));

        return result.divide(BigInteger.valueOf(n));

    }

}
