package com.reddit.r_dailyprogrammer_challenge;

import org.apache.commons.lang3.StringUtils;


public class Ch380 {

    public static void main(String[] args) {

        getAllSeeds(".--...-.-.-.....-.--........----.-.-..---.---.--.--.-.-....-..-...-.---..--.----..");

    }

    public static boolean checkAvailability(int... index) {

        for (int i = 1; i < index.length; i++) {
            if (index[0] == index[i]) {
                return false;
            }
        }
        return true;
    }

    public static void validateCode(String morseCode) {

        if (morseCode.length() != 82) {
            throw new IllegalArgumentException("Invalid code");
        }

        int dotsCounter = 0;

        for (int i = 0; i < morseCode.length(); i++) {

            if (morseCode.charAt(i) != '.' && morseCode.charAt(i) != '-') {
                throw new IllegalArgumentException("Invalid code");
            }
            if (morseCode.charAt(i) == '.') {
                dotsCounter++;
            }
        }

        if (dotsCounter != 44) {
            throw new IllegalArgumentException("Invalid code");
        }


    }


    public static void getAllSeeds(String morseCode) {
        validateCode(morseCode);
        int[] temp = new int[26];
        long counter = 0;
        String alphabet = new String();

        for (int i_1_1 = 0; i_1_1 < temp.length; i_1_1++) {

            for (int i_1_2 = i_1_1 + 1; i_1_2 < temp.length; i_1_2++) {

                temp[i_1_1] = 1;
                temp[i_1_2] = 1;

                for (int i_2_1 = 0; i_2_1 < temp.length; i_2_1++) {

                    if (checkAvailability(i_2_1, i_1_1, i_1_2)) {

                        for (int i_2_2 = i_2_1 + 1; i_2_2 < temp.length; i_2_2++) {

                            if (checkAvailability(i_2_2, i_2_1, i_1_1, i_1_2)) {

                                for (int i_2_3 = i_2_2 + 1; i_2_3 < temp.length; i_2_3++) {

                                    if (checkAvailability(i_2_3, i_2_2, i_2_1, i_1_1, i_1_2)) {

                                        for (int i_2_4 = i_2_3 + 1; i_2_4 < temp.length; i_2_4++) {

                                            if (checkAvailability(i_2_4, i_2_3, i_2_2, i_2_1, i_1_1, i_1_2)) {

                                                temp[i_2_1] = 2;
                                                temp[i_2_2] = 2;
                                                temp[i_2_3] = 2;
                                                temp[i_2_4] = 2;

                                                for (int i_3_1 = 0; i_3_1 < temp.length; i_3_1++) {

                                                    if (checkAvailability(i_3_1, i_2_4, i_2_3, i_2_2, i_2_1, i_1_1, i_1_2)) {

                                                        for (int i_3_2 = i_3_1 + 1; i_3_2 < temp.length; i_3_2++) {

                                                            if (checkAvailability(i_3_2, i_3_1, i_2_4, i_2_3, i_2_2, i_2_1, i_1_1, i_1_2)) {

                                                                for (int i_3_3 = i_3_2 + 1; i_3_3 < temp.length; i_3_3++) {

                                                                    if (checkAvailability(i_3_3, i_3_2, i_3_1, i_2_4, i_2_3, i_2_2, i_2_1, i_1_1, i_1_2)) {

                                                                        for (int i_3_4 = i_3_3 + 1; i_3_4 < temp.length; i_3_4++) {

                                                                            if (checkAvailability(i_3_4, i_3_3, i_3_2, i_3_1, i_2_4, i_2_3, i_2_2, i_2_1, i_1_1, i_1_2)) {

                                                                                for (int i_3_5 = i_3_4 + 1; i_3_5 < temp.length; i_3_5++) {

                                                                                    if (checkAvailability(i_3_5, i_3_4, i_3_3, i_3_2, i_3_1, i_2_4, i_2_3, i_2_2, i_2_1, i_1_1, i_1_2)) {

                                                                                        for (int i_3_6 = i_3_5 + 1; i_3_6 < temp.length; i_3_6++) {

                                                                                            if (checkAvailability(i_3_6, i_3_5, i_3_4, i_3_3, i_3_2, i_3_1, i_2_4, i_2_3, i_2_2, i_2_1, i_1_1, i_1_2)) {

                                                                                                for (int i_3_7 = i_3_6 + 1; i_3_7 < temp.length; i_3_7++) {

                                                                                                    if (checkAvailability(i_3_7, i_3_6, i_3_5, i_3_4, i_3_3, i_3_2, i_3_1, i_2_4, i_2_3, i_2_2, i_2_1, i_1_1, i_1_2)) {

                                                                                                        for (int i_3_8 = i_3_7 + 1; i_3_8 < temp.length; i_3_8++) {

                                                                                                            if (checkAvailability(i_3_8, i_3_7, i_3_6, i_3_5, i_3_4, i_3_3, i_3_2, i_3_1, i_2_4, i_2_3, i_2_2, i_2_1, i_1_1, i_1_2)) {

                                                                                                                temp[i_3_1] = 3;
                                                                                                                temp[i_3_2] = 3;
                                                                                                                temp[i_3_3] = 3;
                                                                                                                temp[i_3_4] = 3;
                                                                                                                temp[i_3_5] = 3;
                                                                                                                temp[i_3_6] = 3;
                                                                                                                temp[i_3_7] = 3;
                                                                                                                temp[i_3_8] = 3;

                                                                                                                for (int i = 0; i < temp.length; i++) {

                                                                                                                    if (checkAvailability(i, i_3_8, i_3_7, i_3_6, i_3_5, i_3_4, i_3_3, i_3_2, i_3_1, i_2_4, i_2_3, i_2_2, i_2_1, i_1_1, i_1_2)) {

                                                                                                                        temp[i] = 4;

                                                                                                                    }

                                                                                                                }
                                                                                                                counter++;

                                                                                                                alphabet = checkAlphabetPermutations(temp, morseCode);
                                                                                                                if (!alphabet.equals("?")) {
                                                                                                                    System.out.println(counter + " " + alphabet);
                                                                                                                }


                                                                                                            }

                                                                                                        }


                                                                                                    }

                                                                                                }


                                                                                            }

                                                                                        }


                                                                                    }

                                                                                }


                                                                            }


                                                                        }


                                                                    }


                                                                }


                                                            }

                                                        }

                                                    }


                                                }


                                            }


                                        }

                                    }


                                }
                            }

                        }

                    }

                }
            }
        }


    }


    public static String checkAlphabetPermutations(int[] seed, String morseCode) {

        char[] letters = new char[26];
        int lengthDecoded = 0;

        for (int i = 0; i < seed.length; i++) {
            letters[i] = decode(morseCode.substring(lengthDecoded, lengthDecoded + seed[i]));
            if (letters[i] == '?') {
                return "?";
            }
            for (int j = 0; j < i; j++) {
                if (letters[i] == letters[j]) {
                    return "?";
                }
            }
            lengthDecoded += seed[i];
        }

        return StringUtils.valueOf(letters);

    }


    public static char decode(String morseCode) {

        if (morseCode.length() == 0 || morseCode.length() > 4) {
            throw new IllegalArgumentException("Invalid code");
        }

        for (int i = 0; i < morseCode.length(); i++) {

            if (morseCode.charAt(i) != '.' && morseCode.charAt(i) != '-') {
                throw new IllegalArgumentException("Invalid code");
            }
        }

        String[] alphabetInMorseCode = {
                ".-",        //A
                "-...",        //B
                "-.-.",        //C
                "-..",        //D
                ".",        //E
                "..-.",        //F
                "--.",        //G
                "....",        //H
                "..",        //I
                ".---",        //J
                "-.-",        //K
                ".-..",        //L
                "--",        //M
                "-.",        //N
                "---",        //O
                ".--.",        //P
                "--.-",        //Q
                ".-.",        //R
                "...",        //S
                "-",        //T
                "..-",        //U
                "...-",        //V
                ".--",        //W
                "-..-",        //X
                "-.--",        //Y
                "--.."};    //Z

        int index = -1;
        for (int i = 0; i < alphabetInMorseCode.length; i++) {
            if (morseCode.equals(alphabetInMorseCode[i])) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            return (char) ('a' + index);
        }

        return ('?');


    }


}