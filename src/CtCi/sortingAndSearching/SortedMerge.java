package sortingAndSearching;

import java.util.Arrays;

/*
 * 10.1 Sorted Merge
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the end
 * to hold B. Write a method to merge B into A in sorted order.
 */
public class SortedMerge {

	public static void sortedMerge(int[] a, int countA, int[] b, int countB) {
		int indexMerged = countB + countA - 1; // last element in A
		int indexA = countA - 1; // last non-buffered element in A
		int indexB = countB - 1; // last element in B

		// while there are elements to merge from B
		while (indexB >= 0) {
			// if you are not at the beginning of A and
			// a[indexToCompare] > b[indexToCompare],
			// make current merge spot become a's value
			if (indexA >= 0 && a[indexA] > b[indexB]) {
				a[indexMerged] = a[indexA];
				indexA--;
				// else make current merge spot become b's value
			} else {
				a[indexMerged] = b[indexB];
				indexB--;
			}
			//decrement merged portion
			indexMerged--;
		}
	}

	public static void main(String[] args) {
		int[] test = { 1, 2, 3, 4, 0, 0, 0 };
		int[] test2 = { 2, 5, 6 };

		System.out.println("A: " + Arrays.toString(test));
		System.out.println("B: " + Arrays.toString(test2));
		sortedMerge(test, 4, test2, 3);
		System.out.println("Merged: " + Arrays.toString(test));
	}

}
