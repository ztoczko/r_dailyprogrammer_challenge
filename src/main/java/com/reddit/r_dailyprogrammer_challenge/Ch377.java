package com.reddit.r_dailyprogrammer_challenge;

import org.apache.commons.lang3.ArrayUtils;

public class Ch377 {

    public static void main(String[] args) {

//		int[] shuffle = new int[6];
//		for (int i = 0; i < 100; i++) {
//			shuffle = getNextShuffle(shuffle);
//			System.out.println(Arrays.toString(shuffle));
//		}
//


        int[] spaceSize = {123, 456, 789, 1011, 1213, 1415}; // {12, 10, 12, 10, 15};
        int[] boxSize = {16, 17, 18, 19, 20, 21};//{1, 5, 1, 3, 3};

        System.out.println(getNumberOfCrates(true, spaceSize, boxSize));

    }


    public static long getNumberOfCrates(boolean isShiftAllowed, int[] spaceSize, int[] boxSize) {

        if (spaceSize.length != boxSize.length || spaceSize.length == 0) {
            return -1;
        }

        if (!isShiftAllowed) {
            return simpleFit(spaceSize, boxSize);
        }

        int[] shuffle = new int[boxSize.length];

        for (int i = 0; i < boxSize.length; i++) {
            shuffle[i] = i;
        }

        long result = 0;

        int[] boxShuffled = new int[boxSize.length];


        while (true) {

            boxShuffled = transformBox(shuffle, boxSize);
            if (simpleFit(spaceSize, boxShuffled) > result) {
                result = simpleFit(spaceSize, boxShuffled);
            }
            shuffle = getNextShuffle(shuffle);
            if (compareShuffleToInitialShuffle(shuffle)) {
                break;
            }
        }


        return result;
    }


    private static long simpleFit(int[] spaceSize, int[] boxSize) {

        long result = 1;

        for (int i = 0; i < spaceSize.length; i++) {
            result *= spaceSize[i] / boxSize[i];
        }

        return result;

    }

    private static int[] getNextShuffle(int[] shuffle) {

        while (true) {

            for (int i = shuffle.length - 1; i >= 0; i--) {
                shuffle[i]++;
                if (shuffle[i] == shuffle.length) {
                    shuffle[i] = 0;
                } else {
                    break;
                }
            }

            for (int i = 0; i < shuffle.length; i++) {
                if (!ArrayUtils.contains(shuffle, i)) {
                    break;
                }
                if (i == shuffle.length - 1) {
//					System.out.println(Arrays.toString(shuffle));
                    return shuffle;
                }
            }

        }

    }

    private static boolean compareShuffleToInitialShuffle(int[] shuffle) {

        for (int i = 0; i < shuffle.length; i++) {
            if (shuffle[i] != i) {
                return false;
            }
        }

        return true;
    }

    private static int[] transformBox(int[] shuffle, int[] boxSize) {

        int[] result = new int[shuffle.length];
        for (int i = 0; i < shuffle.length; i++) {
            result[i] = boxSize[shuffle[i]];
        }
        return result;

    }
}

