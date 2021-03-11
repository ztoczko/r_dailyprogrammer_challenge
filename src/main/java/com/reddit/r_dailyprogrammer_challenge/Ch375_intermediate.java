package com.reddit.r_dailyprogrammer_challenge;

//https://www.reddit.com/r/dailyprogrammer/comments/aq6gfy/20190213_challenge_375_intermediate_a_card/

import java.util.Arrays;

public class Ch375_intermediate {
	
	public static void main (String[] args) {
		
		int[] input = {0, 1, 0, 0, 1, 1, 0};		
		System.out.println(isSequenceSolvable(input) == null ? "unsolvable" : Arrays.toString(solveSequence(input)));
		
		input = new int[] {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1};
		System.out.println(isSequenceSolvable(input) == null ? "unsolvable" : Arrays.toString(solveSequence(input)));
		
		input = new int[] {1, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0};
		System.out.println(isSequenceSolvable(input) == null ? "unsolvable" : Arrays.toString(solveSequence(input)));
		
		input = new int[] {0, 1, 0, 0, 1, 1, 0};
		System.out.println(isSequenceSolvable(input) == null ? "unsolvable" : Arrays.toString(solveSequence(input)));
		
		input = new int[] {0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0};
		System.out.println(isSequenceSolvable(input) == null ? "unsolvable" : Arrays.toString(solveSequence(input)));
		
		input = new int[] {1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1};
		System.out.println(isSequenceSolvable(input) == null ? "unsolvable" : Arrays.toString(solveSequence(input)));
		
		input = new int[] {1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0};
		System.out.println(isSequenceSolvable(input) == null ? "unsolvable" : Arrays.toString(solveSequence(input)));
		
		input = new int[] {0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0 ,0, 0};
		System.out.println(isSequenceSolvable(input) == null ? "unsolvable" : Arrays.toString(solveSequence(input)));	
		
	}
	
	public static int[] isSequenceSolvable (int[] sequence) {
		
		int[] isLeftBigger = new int[sequence.length - 1];
		
		isLeftBigger[0] = (sequence[0] == 0 ? 1 : 0);
		
		for (int i = 1; i < isLeftBigger.length; i++) {
			isLeftBigger[i] = (sequence[i] == 0 ? isLeftBigger[i - 1] : isLeftBigger[i - 1] == 1 ? 0 : 1);
		}		
		
		if (isLeftBigger[isLeftBigger.length - 1] != sequence[sequence.length - 1]) {
			return null;
		}				
		return isLeftBigger;
	}
	
	public static int[] solveSequence (int[] sequence) {
		
		int[] result = new int[0],
				isLeftBigger = isSequenceSolvable(sequence);
		boolean leftClear = false,
				rightClear = false;
		
		while (result.length != sequence.length) {
			
		for (int i = 0; i < sequence.length; i++) {
			leftClear = false;
			rightClear = false;
			if (sequence[i] == 1) {
				if (i == 0) {
					leftClear = true;
				}
				if (!leftClear) {
					if (sequence[i - 1] == 2 || isLeftBigger[i-1] == 1) {
						leftClear = true;
					}
				}
				if (i == sequence.length - 1) {
					rightClear = true;
				}
				if (!rightClear) {
					if (sequence[i + 1] == 2 || isLeftBigger[i] == 0) {
						rightClear = true;
					}
				}
				
				if (leftClear && rightClear) {
					result = Arrays.copyOf(result, result.length + 1);
					result[result.length - 1] = i;
					sequence[i] = 2;
					if (i != 0) {
						switch (sequence[i - 1]) {
							case 0:
								sequence[i - 1] = 1;
								break;
							case 1:
								sequence[i - 1] = 0;
								break;
							default:								
								break;
						}
								
					}
					if (i != sequence.length - 1) {
						switch (sequence[i + 1]) {
						case 0:
							sequence[i + 1] = 1;
							break;
						case 1:
							sequence[i + 1] = 0;
							break;
						default:								
							break;
					}
					}
					break;
				}				
			}
		}
	}
		return result;
		
	}

}
