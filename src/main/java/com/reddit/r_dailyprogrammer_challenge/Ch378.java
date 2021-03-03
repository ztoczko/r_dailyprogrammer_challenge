package com.reddit.r_dailyprogrammer_challenge;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;

public class Ch378 {

    public static void main(String[] args) {

        System.out.println(havelHakimi(5, 3, 0, 2, 6, 2, 0, 7, 2, 5));

        System.out.println(havelHakimi(16, 9, 9, 15, 9, 7, 9, 11, 17, 11, 4, 9, 12, 14, 14, 12, 17, 0, 3, 16));

    }

    public static boolean havelHakimi(int... arrayToCheck) {

        int n = 0;
        int[] indexesToRemove = new int[0];

        while (true) {

            indexesToRemove = Arrays.copyOf(indexesToRemove, 0);
            for (int i = 0; i < arrayToCheck.length; i++) {

                if (arrayToCheck[i] == 0) {

                    indexesToRemove = Arrays.copyOf(indexesToRemove, indexesToRemove.length + 1);
                    indexesToRemove[indexesToRemove.length - 1] = i;
                }
            }

            for (int i = indexesToRemove.length - 1; i >= 0; i--) {
                arrayToCheck = ArrayUtils.remove(arrayToCheck, indexesToRemove[i]);
            }


            if (arrayToCheck.length == 0) {
                return true;
            }

            Arrays.sort(arrayToCheck);
            ArrayUtils.reverse(arrayToCheck);
            n = arrayToCheck[0];
            arrayToCheck = ArrayUtils.remove(arrayToCheck, 0);
            if (n > arrayToCheck.length) {
                return false;
            }

            for (int i = 0; i < n; i++) {
                arrayToCheck[i]--;
            }

        }


    }


}
