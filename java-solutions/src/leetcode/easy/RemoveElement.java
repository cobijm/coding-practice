package easy;

import java.util.Arrays;

/*
 * 27. Remove Element
 */
public class RemoveElement {
	public static int removeElement(int[] nums, int val) {
		int len = nums.length;
		int end = nums.length - 1;
		for (int i = 0; i < len; i++) {
			if (nums[i] == val) {
				if (nums[end] != val) {
					swap(nums, i, end);
					end--;
					len--;
				} else {
					swap(nums, i, end);
					end--;
					len--;
					i--;
				}
			}
		}
		return len;
	}

	public static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {3,2,2,3};
		System.out.println(removeElement(test, 3));
		System.out.println(Arrays.toString(test));
	}

}
