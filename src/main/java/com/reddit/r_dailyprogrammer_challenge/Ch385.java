package com.reddit.r_dailyprogrammer_challenge;

//https://www.reddit.com/r/dailyprogrammer/comments/hrujc5/20200715_challenge_385_intermediate_the_almost/

import java.util.Random;

public class Ch385 {

    public static void main(String[] args) {

        int[] chessboard = generateChessboard();

        chessboard = prisoner1modification(chessboard, 26);
        System.out.println(prisoner2solution(chessboard));

    }

    public static int[] generateChessboard() {

        Random r = new Random();
        int[] chessboard = new int[64];

        for (int i = 0; i < chessboard.length; i++) {
            chessboard[i] = r.nextInt(2);
        }
        return chessboard;

    }

    public static int[] getChessboardSeed(int[] chessboard) {

        int[] seed = new int[6];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 64; j++) {
                if ((j / (int) (Math.pow(2, (5 - i)))) % 2 == 1) {            // checking whether field is inside i-th "bit" //Math.pow value in relation to i: 0-32  1-16   2-8  3-4   4-2   5-1
                    seed[i] += chessboard[j];                                   // counting fields with "1"
                }
            }
            seed[i] = seed[i] % 2;                                          // getting final seed value for index i - 1 if number of appearances of "1" inside "bit" is odd
        }

        return seed;
    }

    public static int[] prisoner1modification(int[] chessboard, int magicTile) {

        int[] magicTileBinary = new int[6];

        for (int i = 0; i < 6; i++) {
            magicTileBinary[i] = magicTile / (int) Math.pow(2, (5 - i));
            if (magicTileBinary[i] == 1) {
                magicTile -= (int) Math.pow(2, (5 - i));
            }
        }

        int[] chessboardSeed = getChessboardSeed(chessboard);

        int[] parity = new int[6];

        for (int i = 0; i < 6; i++) {
            parity[i] = magicTileBinary[i] == chessboardSeed[i] ? 0 : 1;            //finding difference between chessboard seed and binary value of magic field
        }

        int parityIndex = binaryToDecimal(parity);

        chessboard[parityIndex] = chessboard[parityIndex] == 1 ? 0 : 1;             //one and only flip of a coin changing chessboard seed to value of magic field

        return chessboard;
    }


    public static int prisoner2solution(int[] chessboard) {
        return binaryToDecimal(getChessboardSeed(chessboard));
    }

    public static int binaryToDecimal(int[] binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length; i++) {
            decimal += binary[i] * (int) Math.pow(2, (binary.length - 1 - i));
        }
        return decimal;
    }


}


