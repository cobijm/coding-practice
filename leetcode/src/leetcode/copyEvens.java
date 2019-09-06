package leetcode;

public class copyEvens {

	public static int[] copyEven(int[] nums, int count) {
		int[] result = new int[count];
		int num = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0) {
				result[num] = nums[i];
				num++;
			}
			
			if(result[result.length - 1] != 0) {
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {3, 2, 4, 5, 8};
		System.out.println(copyEven(nums, 2));
	}
}
