import java.util.Arrays;

public class FirstMissingPositive {

	public static int firstMissingPositive(int[] nums) {
		int highest = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > highest) {
				highest = nums[i];
			}
		}
		boolean[] set = new boolean[Math.abs(highest + 2)];
		set[0] = true;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 1) {
				continue;
			} else {
				set[nums[i]] = true;
			}
		}

		for (int i = 0; i < set.length; i++) {
			if (set[i] == false) {
				return i;
			}
		}
		return 0;
	}
	
		public static void main(String[] args) {
		int[] test = { 3, 4, -1, 1 };
		System.out.println(Arrays.toString(test));
		System.out.println(firstMissingPositive(test));
	}

}
