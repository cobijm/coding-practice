from typing import List

# ============================================================================
# PROBLEM DESCRIPTION: (Blind 75 - Easy)
# ============================================================================
#
# LeetCode 268: Missing Number
#
# Given an array `nums` containing `n` distinct numbers in the range `[0, n]`,
# return the only number in the range that is missing from the array.
#
# Example 1:
#   Input: nums = [3, 0, 1]
#   Output: 2
#   Explanation: n = 3 since there are 3 numbers, so the range is [0, 3].
#   2 is the missing number in the range since it does not appear in nums.
#
# Example 2:
#   Input: nums = [0, 1]
#   Output: 2
#
# Example 3:
#   Input: nums = [9, 6, 4, 2, 3, 5, 7, 0, 1]
#   Output: 8
#
# ============================================================================

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        # =================================================================
        # YOUR CODE GOES HERE
        #
        # There are several great ways to solve this!
        #
        # --- Hint for Set-Based Approach (O(n) time, O(n) space) ---
        # 1. You can convert `nums` into a set for fast O(1) lookups.
        # 2. The full range of numbers should be from 0 to `n`, where `n` is
        #    the length of the `nums` array.
        # 3. You can loop from 0 to `n` (inclusive) and check if each number
        #    is present in your set. The first one you find that isn't
        #    present is your answer.
        #
        # --- Hint for Math-Based Approach (O(n) time, O(1) space) ---
        # 1. The sum of a sequence of numbers from 0 to n can be calculated
        #    with a formula (Gauss's formula): expected_sum = n * (n + 1) // 2.
        # 2. Calculate the actual sum of the numbers in the `nums` array.
        # 3. The difference between the `expected_sum` and the `actual_sum`
        #    will be the missing number.
        # =================================================================

        # # convert to set for O(1) lookups
        # num_set = set(nums)
        # # loop through length of nums including the last element
        # for counter in range(len(nums) + 1):
        #     # if number not in set, there's our guy
        #     if counter not in num_set:
        #         return counter
        # return counter
    
        # math based approach
        num_len = len(nums)
        # [3, 0, 1] = 3 * (3 + 1) // 2 = 6
        expected_sum = num_len * (num_len + 1) // 2
        actual_sum = 0
        # 3 + 0 + 1 = 4
        for num in nums:
            actual_sum += num
        # 6 - 4 = 2
        return expected_sum - actual_sum
    
        # # bit manipulation solution
        # # Let n be the length of the list (e.g., 3 for [3,0,1])
        # n = len(nums)
    
        # # Initialize the result with 'n'. We do this because the full range
        # # is [0, 1, ..., n], but the loop over `nums` will only give us
        # # indices from 0 to n-1. So, we start with `n` to account for it.
        # result = n
    
        # # Use enumerate to get both the index (i) and the number (num)
        # # The indices will cover 0, 1, ..., n-1 (the start of our full range)
        # # The numbers will cover the values in nums.
        # for i, num in enumerate(nums):
        # # In each step, we XOR the index from the "complete" set
        # # and the number from the "actual" set.
        # result ^= i
        # result ^= num
        
        # return result

# ============================================================================
# TEST CASES (Do not modify)
# ============================================================================
if __name__ == '__main__':
    solver = Solution()

    print("--- Testing Missing Number ---")

    test_cases = [
        ([3, 0, 1], 2),
        ([0, 1], 2),
        ([9, 6, 4, 2, 3, 5, 7, 0, 1], 8),
        ([0], 1)
    ]

    for i, (nums_test, expected) in enumerate(test_cases):
        print(f"\nTest Case {i+1}: Input: nums = {nums_test}")
        
        try:
            result = solver.missingNumber(nums_test)
            print(f"Your Output: {result}")
            print(f"Expected:    {expected}")
            assert result == expected, "Assertion failed!"
            print("✅ Passed")
        except Exception as e:
            print(f"An error occurred: {e}")
            print("❌ Failed")