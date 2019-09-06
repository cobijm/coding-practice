package leetcode;

public class dividesSelf {

	public static boolean divideSelf(int n) {
		  int test = n;
		  int leftover = n;
		  int length = String.valueOf(n).length();
		  for(int i = 0; i < length; i++) {
		    test = leftover % 10;
		    if(test == 0 || n % test != 0) {
		      return false;
		    }
		    leftover /= 10;
		  }
		  return true;
		}

	public static void main(String[] args) {

		System.out.println(divideSelf(32));

	}

}
