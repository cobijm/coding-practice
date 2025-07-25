package random;

public class FindMaxInMinheap {

	public static int findMax(int[] heap, int n) {
		int max = heap[n / 2];
		
		for(int i = 1 + n / 2; i < n; i++) {
			max = Math.max(max, heap[i]);
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {10,25,23,45,50,30,35,84,65,92};
		System.out.println(findMax(test, test.length));
	}

}
