package easy;

import java.util.Arrays;

public class RotateArray {

    public static void rotate(int[] nums, int k) {
        int[] copy = nums;
        int count = 0;
        for(int i = nums.length - k + 1; i < nums.length; i++) {
            nums[count] = copy[i];
            count++;
        }
        for(int i = 0; i < nums.length - k + 1; i++) {
            nums[count] = copy[i];
            count++;
        }
    }
    
	public static void main(String[] args) {
		int[] test = {1,2,3,4,5,6,7};
		rotate(test, 3);
		System.out.println(Arrays.toString(test));

	}

}
