# 128. Longest Consecutive Sequence

from typing import List

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        """
        Finds the single number in a list where every other number appears twice.
        This is a direct translation of the HashSet logic from Java.
        """
        num_set = set() # This is Python's equivalent of a HashSet
        
        for current_num in nums:
            if current_num not in num_set:
                num_set.add(current_num)
            else:
                num_set.remove(current_num)
        
        # At the end, the set contains exactly one number. .pop() removes and returns it.
        return num_set.pop()
    
        # The logic relies on two properties of XOR:
        # 1. A number XOR'd with itself is 0 (e.g., 5 ^ 5 = 0)
        # 2. A number XOR'd with 0 is itself (e.g., 5 ^ 0 = 5)
        #
        # If we XOR all numbers, pairs will cancel out to 0, leaving the single number.
        # Example: [4, 1, 2, 1, 2] -> (4 ^ (1^1) ^ (2^2)) -> (4 ^ 0 ^ 0) -> 4
        
        # One way to write it:
        # result = 0
        # for num in nums:
        #     result ^= num
        # return result
        
        # An even more concise, functional way using reduce:
        # return reduce(lambda a, b: a ^ b, nums)

if __name__ == "__main__":
    # 1. Create an instance of your solution class
    solver = Solution()
    
    # 2. Define your test cases
    # Each test case is a tuple: (input_list, expected_output)
    test_cases = [
        ([2, 2, 1], 1),
        ([4, 1, 2, 1, 2], 4),
        ([1], 1),
        ([7, 3, 3, 9, 9, 7, 5], 5),
        ([-1, 1, -1], 1),
    ]
    
    # 3. Loop through the test cases and run them
    print("Running test cases...")
    for i, (nums, expected) in enumerate(test_cases):
        # Call the method on your solver instance
        actual = solver.singleNumber(nums)
        
        # Compare the actual result with the expected result
        if actual == expected:
            print(f"  - Input:    {nums}")
            print(f"  - Expected: {expected}")
            print(f"  - Actual:   {actual}")
            print(f"Test Case {i+1}: PASSED")
        else:
            print(f"Test Case {i+1}: FAILED")
            print(f"  - Input:    {nums}")
            print(f"  - Expected: {expected}")
            print(f"  - Actual:   {actual}")
    print("All test cases finished.")