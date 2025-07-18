package easy;
/*
 * 121. Best Time to Buy and Sell Stock
 */
public class MaxProfit {

	/* Brute Force
	 * O(n^2)
	 */
    public static int maxProfit1(int[] prices) {
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            for(int j = i + 1; j < prices.length; j++) {
                if((prices[j] - prices[i]) > maxProfit) {
                    maxProfit = prices[j] - prices[i];
                }
            }
        }
        return maxProfit;
    }
    
    /* One pass algorithm, peaks and valleys
     * O(n)
     */
    public static int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
        	if(prices[i] < minPrice) {
        		minPrice = prices[i];
        	}
        	if(prices[i] - minPrice > maxProfit) {
        		maxProfit = prices[i] - minPrice;
        	}
        }
        return maxProfit;
    }
	public static void main(String[] args) {
		int[] test = {7,1,5,3,6,4};
		System.out.println(maxProfit2(test));
	}

}
