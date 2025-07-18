package easy;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 283. Move Zeroes
 */
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int zeroes = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                zeroes++;
            }
        }
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                temp.add(nums[i]);
            }
        }
        while(zeroes > 0) {
            temp.add(0);
            zeroes--;
        }
        
        
        for(int i = 0; i < temp.size(); i++) {
        	nums[i] = temp.get(i);
        }
    }
    
	public static void main(String[] args) {
		int[] test = {0,1,0,3,12};
		moveZeroes(test);
		System.out.println(Arrays.toString(test));

	}

}
