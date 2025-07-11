package arrays;

import java.util.Arrays;

public class PlusOne {
	
	//doesn't account for overflow
	public static int[] plusOne(int[] digits) {
		int offset = digits.length - 1;
		int num = 0;
		for (int i = 0; i < digits.length; i++) {
			num += digits[i] * Math.pow(10, offset);
			offset--;
		}
		num += 1;
		int[] result = new int[Integer.toString(num).length()];
		for (int i = result.length - 1; i >= 0; i--) {
			int temp = num % 10;
			result[i] = temp;
			num /= 10;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] test = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		System.out.println(Arrays.toString(test));
		System.out.println(Arrays.toString(plusOne(test)));
	}

}
