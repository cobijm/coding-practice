package random;

import java.util.Arrays;

public class Permutation {

	public static boolean permutation(String a, String b) {
		char[] aArr = a.toCharArray();
		char[] bArr = b.toCharArray();
		
		Arrays.sort(aArr);
		Arrays.sort(bArr);
		
		if(Arrays.equals(aArr, bArr)) {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		String test1 = "god";
		String test2 = "dog";
		System.out.println(permutation(test1, test2));
	}

}
