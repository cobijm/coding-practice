package random;

import java.util.Arrays;

public class codeRetreat {

	public static char[] rearrange(char[] arr) {
		
//		Arrays.sort(arr);		
		while(check(arr) != true) {
			re(arr);
		}
		
		return arr;
	}
	
	public static boolean check(char[] arr) {
		for(int i = 1; i < arr.length; i++) {
			if(arr[i - 1] == arr[i]) {
				return false;
			}		
		}
		return true;
	}
	
	public static void re(char[] arr) {
		for(int j = 1; j < arr.length; j++) {
			if(arr[j - 1] == arr[j]) {
				swap(j, j + 1, arr);
			}			
		}
	}
	
	public static void swap(int a, int b, char[] arr) {
		char temp = arr[a];
	    arr[a] = arr[b];
	    arr[b] = temp;
	}
	
	public static void main(String[] args) {
		char[] test = {'c', 'c', 'c', 'c', 'a', 'c', 'b', 'h', 'j', 'j', 'k', 'l'};
		System.out.println(Arrays.toString(rearrange(test)));

	}

}
