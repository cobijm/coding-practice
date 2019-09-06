package leetcode;

import java.util.Arrays;

public class MaxConsecutiveOnes {

	public static int longestOnes(int[] A, int K) {
		int currLongest = 0;
		int longest = 0;
		int buffer = K;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == 1) {
				currLongest++;
			} else if (A[i] == 0 && buffer > 0) {
				currLongest++;
				buffer--;
			} else {
				currLongest = 1;
				buffer = K;
			}
			if (currLongest > longest) {
				longest = currLongest;
			}
		}
		return longest;
	}

	public static void main(String[] args) {
		int[] test = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
		System.out.println(Arrays.toString(test));
		System.out.println(longestOnes(test, 3));

	}

}
