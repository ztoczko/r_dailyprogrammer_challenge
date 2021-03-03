package com.reddit.r_dailyprogrammer_challenge;

import java.math.BigDecimal;

public class Ch379 {

    static final BigDecimal[] CAP = {BigDecimal.valueOf(10000), BigDecimal.valueOf(30000), BigDecimal.valueOf(100000)};
    static final BigDecimal[] RATE = {BigDecimal.valueOf(0), BigDecimal.valueOf(0.1), BigDecimal.valueOf(0.25), BigDecimal.valueOf(0.4)};

    public static void main(String[] args) {

        System.out.println(calculateTax(BigDecimal.valueOf(0)).longValue());
        System.out.println(calculateTax(BigDecimal.valueOf(10000)).longValue());
        System.out.println(calculateTax(BigDecimal.valueOf(10009)).longValue());
        System.out.println(calculateTax(BigDecimal.valueOf(10010)).longValue());
        System.out.println(calculateTax(BigDecimal.valueOf(12000)).longValue());
        System.out.println(calculateTax(BigDecimal.valueOf(56789)).longValue());
        System.out.println(calculateTax(BigDecimal.valueOf(1234567)).longValue());
        System.out.println(calculateIncome(BigDecimal.valueOf(0.00)).longValue());
        System.out.println(calculateIncome(BigDecimal.valueOf(0.06)).longValue());
        System.out.println(calculateIncome(BigDecimal.valueOf(0.09)).longValue());
        System.out.println(calculateIncome(BigDecimal.valueOf(0.32)).longValue());
        System.out.println(calculateIncome(BigDecimal.valueOf(0.40)).longValue());

    }

    public static BigDecimal calculateTax(BigDecimal income) {


        BigDecimal tax = new BigDecimal(0),
                taxedAmount = new BigDecimal(0);

        for (int i = 0; i < CAP.length; i++) {

            if (income.compareTo(CAP[i]) <= 0) {

                tax = tax.add(income.subtract(taxedAmount).multiply(RATE[i]));
                taxedAmount = taxedAmount.add(income.subtract(taxedAmount));

            } else {

                tax = tax.add(CAP[i].subtract(taxedAmount).multiply(RATE[i]));
                taxedAmount = taxedAmount.add(CAP[i].subtract(taxedAmount));

            }
        }

        if (income.compareTo(CAP[CAP.length - 1]) > 0) {

            tax = tax.add(income.subtract(taxedAmount).multiply(RATE[CAP.length]));
        }

        return tax;


    }

    public static BigDecimal calculateIncome(BigDecimal effectiveTaxRate) {

        int checkBracket = -1;

        for (int i = 1; i < RATE.length; i++) {

            if (RATE[i].compareTo(effectiveTaxRate) > 0) {
                checkBracket = i;
                break;
            }
        }

        if (RATE[0].compareTo(effectiveTaxRate) > 0) {
            checkBracket = -1;
        }

        if (checkBracket == -1) {

            return BigDecimal.valueOf(-1);

        }

        return RATE[checkBracket].multiply(CAP[checkBracket - 1]).subtract(calculateTax(CAP[checkBracket - 1])).divide(RATE[checkBracket].subtract(effectiveTaxRate));

    }

}