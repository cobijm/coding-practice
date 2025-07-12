# 1. Two Sum
# Given an array of integers `nums` and an integer `target`, return indices of the
# two numbers such that they add up to `target`.

class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        # dict, Python version of HashMap
        lookup = {}
        # loop through nums using enumerate (generates a tuple with (index, value))
        for index, currentNum in enumerate(nums):
            # determine value needed that adds with current num and equals target
            complement = target - currentNum
            # if it exists in our map, we have a match
            if(complement in lookup):
                return [lookup[complement], index]
            # otherwise, add to map. Key is num, and value is index of that num in nums
            lookup[currentNum] = index
            


if __name__ == '__main__':
    solver = Solution()
    
    print("--- Testing Two Sum ---")
    
    test_cases = [
        ([2, 7, 11, 15], 9, {0, 1}),
        ([3, 2, 4], 6, {1, 2}),
        ([3, 3], 6, {0, 1})
    ]
    
    for i, (nums_test, target_test, expected_indices) in enumerate(test_cases):
        print(f"\nTest Case {i+1}:")
        print(f"Input: nums = {nums_test}, target = {target_test}")
        
        result = solver.twoSum(nums_test, target_test)
        
        # We use a set for comparison because the order of indices doesn't matter.
        result_set = set(result)
        
        print(f"Output: {result}")
        print(f"Expected (any order): {list(expected_indices)}")
        assert result_set == expected_indices, f"Assertion failed for test case {i+1}"
        print("✅ Passed")