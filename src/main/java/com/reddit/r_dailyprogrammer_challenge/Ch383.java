package com.reddit.r_dailyprogrammer_challenge;

import org.apache.commons.lang3.StringUtils;

public class Ch383 {

    public static void main(String[] args) {

        System.out.println(checkNecklace("kupa", "upak"));

    }

    public static boolean checkNecklace(String necklaceA, String necklaceB) {

        if (necklaceA.length() != necklaceB.length()) {
            return false;
        }
        char[] temp = new char[necklaceA.length()];

        for (int i = 0; i < necklaceA.length(); i++) {
            for (int j = 0; j < necklaceA.length(); j++) {
                temp[i + j >= necklaceA.length() ? i + j - necklaceA.length() : i + j] = necklaceA.charAt(j);
            }
            if (StringUtils.valueOf(temp).equals(necklaceB)){
                return true;
            }

        }

        return false;

    }

}


