package random;

import java.util.Arrays;

/*
 * Two non-negative integers are call
 */
public class LargestInt {

	public static int solution(int N) {

		String temp = Integer.toString(N);
		int[] arr = new int[temp.length()];

		//put every int in N into int[] arr
		for (int i = 0; i < temp.length(); i++) {
			arr[i] = temp.charAt(i) - '0';
		}
		
		//sort array
		Arrays.sort(arr);

		//reverse the sorting
		for (int i = 0; i < arr.length / 2; i++) {
			int tmp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = tmp;
		}

		int result = 0;
		int offset = 1;

		//convert the int arr to int
		for (int i = arr.length - 1; i >= 0; i--) {
			result += arr[i] * offset;
			offset *= 10;
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int test = 123;
		System.out.println(solution(test));

	}

}
