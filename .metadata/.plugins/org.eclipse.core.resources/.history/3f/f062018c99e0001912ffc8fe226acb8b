package leetcode;

import java.util.Arrays;

public class SortArrayByParity {

	public static int[] sortArrayByParity(int[] A) {
		int[] ans = new int[A.length];
        int t = 0;

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 0)
                ans[t++] = A[i];

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 1)
                ans[t++] = A[i];

        return ans;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {3, 1, 2, 4};
		System.out.println(Arrays.toString(sortArrayByParity(test)));
		String test1 = "evenly";
		System.out.println(test1.substring(test1.length() - 2));
	}

}
