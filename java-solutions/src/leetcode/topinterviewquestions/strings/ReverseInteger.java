package strings;

import java.util.Arrays;

public class ReverseInteger {
	public static int reverse(int x) {
		
		String temp = Integer.toString(x);
		boolean isNegative = false;
		int[] intArr = new int[temp.length()];
		int startAt = 0;
		
		//check if negative to know where to start swapping elements
		if(temp.charAt(0) == '-') {
			isNegative = true;
			startAt = 1;
		}
		
		//convert to int array
		for (int i = startAt; i < temp.length(); i++) {
			intArr[i] = temp.charAt(i) - '0';
		}
		
		int end = intArr.length - 1;
		
		//swap numbers in the int array so the int is reversed
		for(int i = startAt; i < end; i++) {
			swap(intArr, i, end);
			end--;
		}
		System.out.println(Arrays.toString(intArr));
		int num = 0;
		
		//convert int array to an int
		for(int a : intArr) {
			num = 10 * num + a;
		}
        int numCopy = num;
        
        //check first integer. if same as the last original int digit, no overflow
        while(numCopy >= 10) {
            numCopy /= 10;
        }
        if(numCopy != intArr[startAt] && intArr[startAt] != 0) {
            return 0;
        }
        
        //if negative, make it negative
		if(isNegative) {
			num *= -1;
		}
		return num;
	}
	
	//helper method to swap elements
	public static void swap(int[] intArr, int a, int b) {
		int temp = intArr[a];
		intArr[a] = intArr[b];
		intArr[b] = temp;
	}

	public static void main(String[] args) {
		int test = 120;
		System.out.println(reverse(test));
	}
}
