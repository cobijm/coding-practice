package leetcode;

import java.util.Arrays;

public class FlipAndInvertImage {

	public static int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0; i < A.length; i++) {
    		A[i] = reverser(A[i]);
        	for(int j = 0; j < A[i].length; j++) {
        		A[i][j] = invert(A[i][j]);
        	}
        }
        return A;
    }
	public static int[] reverser(int[] num) {
	    int[] reversed = new int[num.length];
	    int cur = 0;
	    for (int i = num.length - 1; i > -1; i--) {
	        reversed[cur] = num[i];
	        cur++;
	    }
	    return reversed;
	}
	public static int invert(int a) {
		if(a == 0) {
			return 1;
		}
		else 
			return 0;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {{1,1,0},{1,0,1},{0,0,0},{0,0,1}};
		System.out.println(Arrays.deepToString(test));
		System.out.println(Arrays.deepToString(flipAndInvertImage(test)));

	}

}
