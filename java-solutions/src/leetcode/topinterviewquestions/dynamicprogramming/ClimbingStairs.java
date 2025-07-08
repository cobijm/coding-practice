package dynamicprogramming;

public class ClimbingStairs {
	public static int climbStairs(int n) {
		int memo[] = new int[n + 1];
		return climbStairsHelper(n, memo);
	}

	public static int climbStairsHelper(int n, int memo[]) {
		// base case, if there are negative stairs, there are no ways to climb it
		if (n < 0) {
			return 0;
		}

		// base case, if there are no stairs, there is only one way to climb(by not
		// moving)
		if (n == 0) {
			return 1;
		}

		// if val we're trying to calculate has already been calculated, return that
		if (memo[n] > 0) {
			return memo[n];
		}

		// if you've made it this far, this is a new calculation
		// memo[n] is equal to the two previous steps added together
		memo[n] = climbStairsHelper(n - 1, memo) + climbStairsHelper(n - 2, memo);

		return memo[n];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
