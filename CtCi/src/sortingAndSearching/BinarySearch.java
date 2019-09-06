package sortingAndSearching;

import java.util.Arrays;

public class BinarySearch {

	public static int binarySearch(int[] arr, int x) {
		int low = 0; 
		int high = arr.length - 1;
		int mid;
		
		//while you haven't skimmed down array size to one value
		while(low <= high) {
			//midpoint
			mid = low + (high - low) / 2;
			//if x < midpoint, search upper bound next
			if(arr[mid] < x) {
				low = mid + 1;
			} else if(arr[mid] > x) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		//not found, return -1
		return -1;
	}
	
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
		int[] test = { 5, 4, 3, 6, 1, 2, 8, 7, 0};
		System.out.println(Arrays.toString(test));
		insertionSort(test);
		System.out.println(Arrays.toString(test));
		System.out.println(binarySearch(test, 3));
	}
}
