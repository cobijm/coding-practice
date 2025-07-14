from typing import List

# ============================================================================
# PROBLEM DESCRIPTION:
# ============================================================================
#
# LeetCode 349: Intersection of Two Arrays
#
# Given two integer arrays `nums1` and `nums2`, return an array of their
# intersection. Each element in the result must be unique and you can
# return the result in any order.
#
# Example 1:
#   Input: nums1 = [1, 2, 2, 1], nums2 = [2, 2]
#   Output: [2]
#
# Example 2:
#   Input: nums1 = [4, 9, 5], nums2 = [9, 4, 9, 8, 4]
#   Output: [9, 4] (or [4, 9])
#
# ============================================================================

class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # =================================================================
        # YOUR CODE GOES HERE
        #
        # Hints:
        # 1. The key requirements are "intersection" and "unique". Which
        #    Python data structure is designed for uniqueness and fast
        #    lookups?
        #
        # 2. A good approach is to convert one of the lists into this data
        #    structure to remove its duplicates and allow for O(1) lookups.
        #
        # 3. Then, you can iterate through the *other* list and check if
        #    each of its elements exists in your newly created data structure.
        #
        # 4. Power-user tip: Python's `set` has built-in operators for
        #    set theory. Can you find an operator that performs an
        #    intersection in a single line?
        # =================================================================

        # my solution
        # turn one list into a set. sets contain unique values
        nums1_set = set(nums1)
        intersection = []
        for num in nums2:
            # if current number exists in set, add it to our list and remove from set
            if num in nums1_set:
                intersection.append(num)
                nums1_set.remove(num)
        return intersection

        # # pythonic solution
        # set1 = set(nums1)
        # set2 = set(nums2)
        # return list(set1.intersection(set2))
# ============================================================================
# TEST CASES (Do not modify)
# ============================================================================
if __name__ == '__main__':
    solver = Solution()

    print("--- Testing Intersection of Two Arrays ---")

    test_cases = [
        ([1, 2, 2, 1], [2, 2], [2]),
        ([4, 9, 5], [9, 4, 9, 8, 4], [4, 9]),
        ([], [1, 2], []),
        ([1, 2, 3], [], []),
        ([1, 2, 3], [4, 5, 6], []),
        ([1, 1, 1], [1, 1], [1])
    ]

    for i, (nums1_test, nums2_test, expected) in enumerate(test_cases):
        print(f"\nTest Case {i+1}: Input: nums1 = {nums1_test}, nums2 = {nums2_test}")
        
        try:
            # Sort results to have a consistent order for comparison
            result = sorted(solver.intersection(nums1_test, nums2_test))
            expected_sorted = sorted(expected)

            print(f"Your Output (sorted): {result}")
            print(f"Expected (sorted):    {expected_sorted}")
            assert result == expected_sorted, "Assertion failed!"
            print("✅ Passed")
        except Exception as e:
            print(f"An error occurred: {e}")
            print("❌ Failed")