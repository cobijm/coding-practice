package sortingAndSearching;

import java.util.Arrays;

/* 10.11 Peaks and Valleys
 * In an array of integers, a "peak" is an element which is greater than or equal to the 
 * adjacent integers and a "valley" is an element which is less than or equal to the adjacent
 * integers. For example, in the array {5, 8, 2, 6, 3, 4, 6}, {8,6} are peaks and {5,2} are valleys.
 * Given an array of integers, sort the array into an alternating sequence of peaks and valleys.
 */
public class PeaksAndValleys {

	public static int[] peaksAndValleys(int[] arr) {
		Arrays.sort(arr);
		for(int i = 0; i < arr.length; i += 2) {
			swap(arr, i, i + 1);
		}
		return arr;
	}
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void main(String[] args) {
		int[] test = {5, 3, 2, 1, 4, 6};
		System.out.println("Original     : " + Arrays.toString(test));
		Arrays.sort(test);
		System.out.println("Sorted       : " + Arrays.toString(test));
		System.out.println("Peaks/Valleys: " + Arrays.toString(peaksAndValleys(test)));

	}

}
