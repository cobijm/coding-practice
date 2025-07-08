package sortingAndSearching;

import java.util.Arrays;

public class BubbleSort {

	public static void bubbleSort(int[] toSort) {
		if (toSort.length < 2) {
			return;
		}
		// loop through as many times to ensure sorted
		for (int i = 0; i < toSort.length - 1; i++) {
			// go through UNSORTED area and sort one element per iteration
			for (int j = 0; j < toSort.length - i - 1; j++) {
				// compare each value to the neighbor and swap if less than
				if (toSort[j] > toSort[j + 1]) {
					swap(toSort, j, j + 1);
				}
			}
		}
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void main(String[] args) {
		int[] test = { 5, 4, 3, 6, 1, 2 };
		System.out.println(Arrays.toString(test));
		bubbleSort(test);
		System.out.println(Arrays.toString(test));
	}

}
