package arraysAndStrings;

import java.util.Arrays;

/*
 * 1.2
 * Given two strings, write a method to decide if one is a permutation of the other.
 * Permutation: a way, especially one of several possible variations, in which a set 
 * or number of things can be ordered or arranged.
 */
public class CheckPermutation {

	public boolean checkPermutation(String a, String b) {
		if(a.length() != b.length()) {
			return false;
		}
		char[] aArr = a.toCharArray();
		char[] bArr = b.toCharArray();
		Arrays.sort(aArr);
		Arrays.sort(bArr);
		if(aArr == bArr) {
			return true;
		}
		return false;
	}
	
	public static void main(String args[]) {
		String test1 = "dcb";
		char[] test = test1.toCharArray();
		Arrays.sort(test);
		System.out.println(test);
	}
	
}
