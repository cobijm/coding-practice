from typing import List

# ============================================================================
# PROBLEM DESCRIPTION:
# ============================================================================
#
# LeetCode 217: Contains Duplicate
#
# Given an integer array `nums`, return `true` if any value appears at least
# twice in the array, and return `false` if every element is distinct.
#
# Example 1:
#   Input: nums = [1, 2, 3, 1]
#   Output: true
#
# Example 2:
#   Input: nums = [1, 2, 3, 4]
#   Output: false
#
# ============================================================================

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        # =================================================================
        # YOUR CODE GOES HERE
        #
        # Hints:
        # 1. Think about the properties of a `set`. What happens when you
        #    convert a list with duplicates into a set?
        # 2. How can you compare the original collection to the new one?
        #
        # Alternative Hint:
        # 1. You can iterate through the list and use a set to keep track
        #    of the numbers you've already seen.
        # =================================================================

        # # brute force solution. o(n) for iterating through
        # # create set
        # numSet = set()
        # # loop through nums
        # for num in nums:
        #     # if num exists in set
        #     if num in numSet:
        #         # we have a duplicate, so true
        #         return True
        #     # otherwise we add it to our set
        #     numSet.add(num)
        # # no duplicates found, return false
        # return False

        # convert list to set. this removes duplicates
        numSet = set(nums)
        # if lengths differ, that means there was a duplicate, so true. same length, no dupe, false
        return len(numSet) != len(nums)

    
         

# ============================================================================
# TEST CASES (Do not modify)
# ============================================================================
if __name__ == '__main__':
    solver = Solution()
    
    print("--- Testing Contains Duplicate ---")

    test_cases = [
        ([1, 2, 3, 1], True),
        ([1, 2, 3, 4], False),
        ([1, 1, 1, 3, 3, 4, 3, 2, 4, 2], True),
        ([], False),
        ([10], False)
    ]
    
    for i, (nums_test, expected) in enumerate(test_cases):
        print(f"\nTest Case {i+1}: Input: nums = {nums_test}")
        
        try:
            result = solver.containsDuplicate(nums_test)
            print(f"Your Output: {result}")
            print(f"Expected:    {expected}")
            assert result == expected, "Assertion failed!"
            print("✅ Passed")
        except Exception as e:
            print(f"An error occurred: {e}")
            print("❌ Failed")