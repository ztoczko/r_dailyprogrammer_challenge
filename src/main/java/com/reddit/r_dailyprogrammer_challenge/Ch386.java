package com.reddit.r_dailyprogrammer_challenge;


import java.math.BigInteger;
import java.util.Arrays;

public class Ch386 {

    public static void main(String[] args) {

        System.out.println(PartitionCombinations(66));

    }

    public static BigInteger PartitionCombinations(int number) {

        if (number < 0) {
            throw new IllegalArgumentException("Number can't be negative");
        }

        switch (number) {
            case 0:
                return BigInteger.valueOf(1);

            case 1:
                return BigInteger.valueOf(1);

            default:
                break;
        }

        int[] secondSequence = getSecondSequence(number);
        BigInteger[] resultTable = new BigInteger[number + 1];
        resultTable[0] = BigInteger.valueOf(1);
        resultTable[1] = BigInteger.valueOf(1);

        for (int i = 2; i < resultTable.length; i++) {

            resultTable[i] = new BigInteger("0");

            for (int j = 0; j <= i; j++) {
                if (secondSequence[j] > i) {
                    break;
                }
                resultTable[i] = ((j % 4 == 0) || (j % 4 == 1)) ? resultTable[i].add(resultTable[i - secondSequence[j]]) : resultTable[i].subtract(resultTable[i - secondSequence[j]]);

            }
        }

        return resultTable[resultTable.length - 1];

    }

    public static int[] getSecondSequence(int number) {

        int[] thirdSequence = getThirdSequence(number - 1);
        int[] secondSequence = new int[number];
        int realLength = 0;
        secondSequence[0] = 1;
        for (int i = 1; i < secondSequence.length; i++) {
            secondSequence[i] = secondSequence[i - 1] + thirdSequence[i - 1];
            if (secondSequence[i] > number) {
                realLength = i + 1;
                break;
            }
        }
        return Arrays.copyOf(secondSequence, realLength);

    }

    public static int[] getThirdSequence(int length) {
        int[] thirdSequence = new int[length];
        for (int i = 0; i < length; i++) {
            thirdSequence[i] = (i % 2 == 0 ? (i / 2 + 1) : (i + 2));
        }
        return thirdSequence;
    }

}

