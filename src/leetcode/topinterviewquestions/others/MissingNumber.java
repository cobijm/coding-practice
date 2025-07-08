package others;

import java.util.HashSet;

public class MissingNumber {

	public static int missingNumber(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        
        //add all possible numbers into a hashset
        for(int i = 0; i < nums.length + 1; i++) {
            numbers.add(i);
        }
        
        //remove all elements in the hashset that is contained in nums
        for(int i = 0; i < nums.length; i++) {
            numbers.remove(nums[i]);
        }
        
        //return the only element left in the hashset
        Integer firstElement = numbers.iterator().next();
        return firstElement;
	}
	public static void main(String[] args) {
		int[] test = {9,6,4,2,3,5,7,0,1};
		System.out.println(missingNumber(test));

	}

}
