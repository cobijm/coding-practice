package easy;

import java.util.Arrays;

public class RotateArray {

    public static void rotate(int[] nums, int k) {
        if(k == 0) {
            return;
        }
        if(nums.length == 2 && k == 1) {
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
            return;
        }
        int[] copy = nums.clone();
        int current = 0;
        for(int i = k; i < nums.length; i++) {
            nums[i] = copy[current];
            current++;
        }
        for(int i = 0; i < nums.length - k - 1; i++) {
            nums[i] = copy[current];
            current++;
        }
    }
    
	public static void main(String[] args) {
		//int[] test = {1,2,3,4,5,6,7}; 
		//rotate(test, 3); // expect 5,6,7,1,2,3,4
		int[] test1 = {1,2};
		rotate(test1, 1);
		System.out.println(Arrays.toString(test1));

	}

}
