package sortingAndSearching;

import java.util.Arrays;

public class InsertionSort {

	public static void insertionSort(int[] toSort) {
		//loop through entire array
		for(int i = 0; i < toSort.length - 1; i++) {
			//loop through SORTED portion of array
			for(int j = i + 1; j > 0; j--) {
				//compare current j to index before, and swap if less than. decrement down the SORTED portion
				if(toSort[j] < toSort[j - 1]) {
					swap(toSort, j, j - 1);
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
		int[] test = { 5, 4, 3, 6, 1, 2, 1, 1 };
		System.out.println(Arrays.toString(test));
		insertionSort(test);
		System.out.println(Arrays.toString(test));
	}
}
