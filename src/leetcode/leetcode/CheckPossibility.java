package leetcode;

public class CheckPossibility {
	public static boolean checkPossibility(int[] nums) {
        int check = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                check = nums[i + 1];
                for(int j = i + 2; j < nums.length; j++) {
                    if(check >= nums[j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		int[] test = {3,4,2,3};
		System.out.println(checkPossibility(test));
	}
}
