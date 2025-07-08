package sortingAndSearching;

import java.util.Arrays;

public class SelectionSort {

	public static void selectionSort(int[] toSort) {
		if (toSort.length < 2) {
			return;
		}
		// loop through
		for (int i = 0; i < toSort.length; i++) {
			int currMinIndex = i;
			// check each value and see if it is the lowest in this current search
			for (int j = i + 1; j < toSort.length; j++) {
				// found new lower, make it the currMinIndex
				if (toSort[j] < toSort[currMinIndex]) {
					currMinIndex = j;
				}
			}
			// swap the lowest in this pass to current i
			swap(toSort, i, currMinIndex);
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
		selectionSort(test);
		System.out.println(Arrays.toString(test));
	}
}
