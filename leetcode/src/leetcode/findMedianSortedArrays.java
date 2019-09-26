package leetcode;

import java.util.Arrays;

public class findMedianSortedArrays {

	public static int[] findMSA(int[] nums1, int[] nums2) {
        int count = 0;
        for(int i = nums1[nums1.length - 1]; i < nums2.length; i++) {
            nums1[i] = nums2[count];
            count++;
        }
        sort(nums1);
        return nums1;
    }
    
    static void sort(int arr[]) 
    { 
        int n = arr.length; 
  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (arr[j] < arr[min_idx]) 
                    min_idx = j; 
  
            // Swap the found minimum element with the first 
            // element 
            int temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp; 
        } 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1, 2, 8, 3};
		int[] arr2 = {3};
		System.out.println(Arrays.toString(findMSA(arr1, arr2)));
	}
	public boolean closeFar(int a, int b, int c) {
		  if((b - a) <= 1 && (Math.abs(c - a) > 1) && (Math.abs(c - b) > 1)) {
		    return true;
		  }
		  else if((c - a) <= 1 && (Math.abs(b - a) > 1) && (Math.abs(b - c) > 1)) {
		    return true;
		  }
		  return false;
	}
	public String reverseWords(String s) {
        String word = "";
        String result  = "";
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                result += " " + word;
            }
            word += s.charAt(i);
        }
        return result;
    }


}
