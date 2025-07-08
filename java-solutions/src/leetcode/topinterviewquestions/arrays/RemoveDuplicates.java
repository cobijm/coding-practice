package arrays;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int slow = 0;
        
        for(int fast = 1; fast < nums.length; fast++) {
            if(nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
