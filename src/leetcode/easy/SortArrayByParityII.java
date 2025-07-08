package easy;

import java.util.ArrayList;

/*
 * 922. Sort Array By Parity II
 */
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] A) {
        ArrayList<Integer> even = new ArrayList<Integer>();
        ArrayList<Integer> odd = new ArrayList<Integer>();
        for(int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 0) {
                even.add(A[i]);
            } else {
                odd.add(A[i]);
            }
        }
        return combine(even, odd);
    }
    
    public int[] combine(ArrayList<Integer> even, ArrayList<Integer> odd) {
        int len = even.size() + odd.size();
        int[] result = new int[len];
        int evenIndex = 0;
        int oddIndex = 0;
        for(int i = 0; i < len; i++) {
            if(i % 2 == 0) {
                result[i] = even.get(evenIndex);
                evenIndex++;
            } else {
                result[i] = odd.get(oddIndex);
                oddIndex++;
            }
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
