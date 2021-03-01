package com.reddit.r_dailyprogrammer_challenge;

import java.util.Arrays;

public class Ch381{
	
	public static void main (String[] args) {
		
		long[] numbers = {1654, 1654, 50995, 30864, 1654, 50995, 22747,
			    1654, 1654, 1654, 1654, 1654, 30864, 4868, 1654, 4868, 1654,
			    30864, 4868, 30864};
		
		System.out.println(yahtzee(numbers));
		
	}
	
	
	public static long yahtzee (long[] results) {
		
		if (results.length == 0) {
			throw new IllegalArgumentException("Results table cannot be empty");
		}
		
		Arrays.sort(results);
		long tempResult = results[0], maxResult = results[0];
		
		
		for (int i = 1; i < results.length; i++) {
			if (results[i] == results[i-1]) {
				tempResult += results[i];				
			} else {
				tempResult = results[i];
			}
			if (tempResult > maxResult) {
				maxResult = tempResult;
			}
		}
		
		return maxResult;
		
	}
	
	
	
}