package com.reddit.r_dailyprogrammer_challenge;

public class Ch376 {

    private static final long LEAP_YEARS_IN_900 = 900 / 4 - 7;

    public static void main(String[] args) {

        System.out.println(getLeapYearNo(2016, 2017));
        System.out.println(getLeapYearNo(2019, 2020));
        System.out.println(getLeapYearNo(1900, 1901));
        System.out.println(getLeapYearNo(2000, 2001));
        System.out.println(getLeapYearNo(2800, 2801));
        System.out.println(getLeapYearNo(1234, 5678));
        System.out.println(getLeapYearNo(123456, 7891011));
    }

    public static long getLeapYearNo(long startYear, long endYear) {
        long leapYears = ((endYear - startYear) / 900) * LEAP_YEARS_IN_900;
        endYear -= ((endYear - startYear) / 900) * 900 + (startYear / 900) * 900;
        startYear -= (startYear / 900) * 900;
        if (startYear % 4 != 0) {
            startYear += 4 - (startYear % 4);
        }

        for (long i = startYear; i < endYear; i += 4) {
            if (i % 100 != 0 || i % 900 == 200 || i % 900 == 600) {
                leapYears++;
            }
        }
        return leapYears;
    }
}
