package medium;

import java.util.ArrayList;
import java.util.List;

/*
 * 78. Subsets
 */
public class Subsets {

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>()); // empty set
		for (int i = 0; i < nums.length; ++i) {
			List<List<Integer>> newResult = new ArrayList<>(); // used for new lists
			for (List<Integer> L : result) {
				L = new ArrayList<>(L); // copy
				L.add(nums[i]);
				newResult.add(L);
			}
			result.addAll(newResult); // concatenate
		}
		return result;
	}

	public static void main(String[] args) {
		int[] test = { 1, 2, 3 };
		System.out.println(subsets(test));

	}

}
