package sortingAndSearching;

import java.util.Arrays;

public class MergeSort {

	public static void mergeSort(int[] toSort) {
		if(toSort.length < 2) {
			return;
		}
		
		
	}
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void main(String[] args) {
		int[] test = { 5, 4, 3, 6, 1, 2, 1, 1 };
		System.out.println(Arrays.toString(test));
		mergeSort(test);
		System.out.println(Arrays.toString(test));
	}
}
