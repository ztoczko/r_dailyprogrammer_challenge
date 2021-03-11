package com.reddit.r_dailyprogrammer_challenge;

//https://www.reddit.com/r/dailyprogrammer/comments/aphavc/20190211_challenge_375_easy_print_a_new_number_by/

public class Ch375_easy {

	public static void main (String[] args) {
		
		System.out.println(addOne(6979));
		
	}
	
	public static long addOne(long number) {
		
		int magnitude = 10;				;
		
		while (number / (magnitude / 10) > 0) {
			
			if ((number % magnitude)/(magnitude / 10) != 9) {
				number += magnitude / 10;
			} else {
				number = (number / magnitude) * magnitude * 10 + magnitude + number % (magnitude / 10);
				magnitude *= 10;		
			}
			magnitude *= 10;			
		}		
		return number;
	}
	
	
	
}


