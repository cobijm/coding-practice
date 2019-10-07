package random;

import java.util.Arrays;
import java.util.HashSet;

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
	
	public static boolean permutationHash(int[] a, int[] b) {
		HashSet<Integer> hash = new HashSet<>();
		for(int i : a) {
			hash.add(i);
		}
		for(int j : b) {
			if(hash.contains(j)) {
				hash.remove(j);
			}
		}
		return (hash.isEmpty() == true) ? true : false;
	}
	
	public static void main(String[] args) {
		String test1 = "god";
		String test2 = "dog";
		
		int[] testA = {1,2,3,4,5,7};
		int[] testB = {3,4,2,5,1,6};
		System.out.println(permutation(test1, test2));
		System.out.println(permutationHash(testA, testB));
	}

}
