package sortingandsearching;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortedArray {

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		ArrayList<Integer> sorted = new ArrayList<>();
		int count1 = 0;
		int count2 = 0;

		// loop through and compare values until one array is exhausted
		while (n != 0 && m != 0) {
			if (nums1[count1] <= nums2[count2]) {
				sorted.add(nums1[count1]);
				count1++;
				m--;
			} else {
				sorted.add(nums2[count2]);
				count2++;
				n--;
			}
		}

		// if nums2 was exhausted, there are still elements in nums1 to put in
		if (m > 0) {
			for (int i = count1; m != 0; i++) {
				sorted.add(nums1[i]);
				m--;
			}
		}
		// if nums1 was exhausted, there are still elements in nums2 to put in
		if (n > 0) {
			for (int i = count2; n != 0; i++) {
				sorted.add(nums2[i]);
				n--;
			}
		}
		// put values from the arraylist into the nums1 array
		for (int i = 0; i < sorted.size(); i++) {
			nums1[i] = sorted.get(i);
		}
	}

	public static void main(String[] args) {
		int[] test1 = { 1, 2, 3, 0, 0, 0 };
		int[] test2 = { 2, 5, 6 };
		merge(test1, 3, test2, 3);
		System.out.println(Arrays.toString(test1));

	}

}
