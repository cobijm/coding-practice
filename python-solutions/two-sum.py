# 1. Two Sum
# Given an array of integers `nums` and an integer `target`, return indices of the
# two numbers such that they add up to `target`.

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_map = {}  # Hash map to store numbers and their indices

        for index, num in enumerate(nums):
            complement = target - num
            if complement in num_map:
                return [num_map[complement], index]  # Return indices
            num_map[num] = index  # Store number and its index
        return [] #no solution, as per the problem statement this shouldn't be hit