from typing import List

# ============================================================================
# PROBLEM DESCRIPTION:
# ============================================================================
#
# LeetCode 121: Best Time to Buy and Sell Stock
#
# You are given an array `prices` where `prices[i]` is the price of a given
# stock on the ith day.
#
# You want to maximize your profit by choosing a single day to buy one stock
# and choosing a different day in the future to sell that stock.
#
# Return the maximum profit you can achieve from this transaction. If you cannot
# achieve any profit, return 0.
#
# Example 1:
#   Input: prices = [7, 1, 5, 3, 6, 4]
#   Output: 5
#   Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6),
#   profit = 6-1 = 5. Note that buying on day 2 and selling on day 1 is not
#   allowed because you must buy before you sell.
#
# Example 2:
#   Input: prices = [7, 6, 4, 3, 1]
#   Output: 0
#   Explanation: In this case, no transaction is done, so the max profit is 0.
#
# ============================================================================

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # =================================================================
        # YOUR CODE GOES HERE
        #
        # Hints:
        # 1. The brute-force approach uses nested loops, which is O(n^2).
        #    You can solve this in a single pass (O(n) time).
        #
        # 2. As you iterate through the prices, you only need to keep track
        #    of two things:
        #      a) What is the lowest price seen so far?
        #      b) What is the maximum profit seen so far?
        #
        # 3. For each price, you can calculate the potential profit if you
        #    were to sell on that day (current price - lowest price seen so far).
        #    Then, update your maximum profit if this potential profit is higher.
        # =================================================================

        # # my solution
        # lowestPrice = 999999
        # maxProfit = 0
        # advancePointer = 0
        # # loop through prices
        # while advancePointer < len(prices):
        #     # if new lowest price found, set it
        #     if prices[advancePointer] < lowestPrice:
        #         lowestPrice = prices[advancePointer]
        #         advancePointer += 1
        #         continue
        #     # if higher max profit found, set it
        #     if (prices[advancePointer] - lowestPrice) > maxProfit:
        #         maxProfit = prices[advancePointer] - lowestPrice
        #     # move forward sliding window
        #     advancePointer += 1
        # return maxProfit


        # cleaner and pythonic
        lowest_price = float('inf') 
        max_profit = 0

        # Use a simple 'for' loop, which is cleaner for iterating over a sequence.
        for price in prices:
            # Check current profit, then use max function to keep track of max
            current_profit = price - lowest_price
            max_profit = max(max_profit, current_profit)

            # Then, update the lowest price for the next iterations.
            lowest_price = min(lowest_price, price)

        return max_profit
# ============================================================================
# TEST CASES (Do not modify)
# ============================================================================
if __name__ == '__main__':
    solver = Solution()

    print("--- Testing Best Time to Buy and Sell Stock ---")

    test_cases = [
        ([7, 1, 5, 3, 6, 4], 5),
        ([7, 6, 4, 3, 1], 0),
        ([1], 0),
        ([2, 4, 1], 2),
        ([2, 1, 2, 1, 0, 1, 2], 2)
    ]
    
    for i, (prices_test, expected) in enumerate(test_cases):
        print(f"\nTest Case {i+1}: Input: prices = {prices_test}")
        
        try:
            result = solver.maxProfit(prices_test)
            print(f"Your Output: {result}")
            print(f"Expected:    {expected}")
            assert result == expected, "Assertion failed!"
            print("✅ Passed")
        except Exception as e:
            print(f"An error occurred: {e}")
            print("❌ Failed")