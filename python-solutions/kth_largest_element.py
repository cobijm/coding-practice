from typing import List
import heapq

# ============================================================================
# PROBLEM DESCRIPTION:
# ============================================================================
#
# LeetCode 215: Kth Largest Element in an Array
#
# Given an integer array `nums` and an integer `k`, return the kth largest
# element in the array.
#
# Note that it is the kth largest element in the sorted order, not the kth
# distinct element.
#
# You must solve it in O(n) average time complexity. (Note: The heap solution
# is O(n log k), which is acceptable for this problem in interviews).
#
# Example 1:
#   Input: nums = [3, 2, 1, 5, 6, 4], k = 2
#   Output: 5
#
# Example 2:
#   Input: nums = [3, 2, 3, 1, 2, 4, 5, 5, 6], k = 4
#   Output: 4
#
# ============================================================================

class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # =================================================================
        # YOUR CODE GOES HERE
        #
        # Hints:
        # 1. The naive solution is to sort the array (O(n log n)) and pick
        #    the element at the correct index. Can you do better?
        #
        # 2. The optimal approach uses a min-heap (priority queue). Python's
        #    `heapq` module provides min-heap functionality.
        #    - `heapq.heappush(heap, item)`
        #    - `heapq.heappop(heap)`
        #
        # 3. Iterate through `nums`. Maintain a min-heap of size `k`. If the
        #    current number is larger than the smallest item in the heap
        #    (the root), what should you do?
        #
        # 4. After iterating through all numbers, what will be at the root
        #    of your min-heap?
        # =================================================================
        
        # # naive solution
        # nums.sort()
        # return nums[len(nums) - k]

        # # pythonic solution
        # sortedListOfSizeK = heapq.nlargest(k, nums)
        # return sortedListOfSizeK[-1]

        # preferred solution
        min_heap = []
        for num in nums:
            # if heap size isn't at least k yet, add it to heap
            if len(min_heap) < k:
                # Add the first k elements to the heap
                heapq.heappush(min_heap, num)
            # If the current number is larger than the smallest element in our heap,
            # replace the smallest with the current number.
            elif num > min_heap[0]:
                # heapreplace is pop THEN push
                heapq.heapreplace(min_heap, num)
            
        # After checking all numbers, the root of the min-heap (min_heap[0])
        # is the k-th largest element overall.
        return min_heap[0]


# ============================================================================
# TEST CASES (Do not modify)
# ============================================================================
if __name__ == '__main__':
    solver = Solution()

    print("--- Testing Kth Largest Element ---")

    test_cases = [
        ([3, 2, 1, 5, 6, 4], 2, 5),
        ([3, 2, 3, 1, 2, 4, 5, 5, 6], 4, 4),
        ([1], 1, 1),
        ([7, 6, 5, 4, 3, 2, 1], 1, 7),
        ([7, 6, 5, 4, 3, 2, 1], 7, 1)
    ]

    for i, (nums_test, k_test, expected) in enumerate(test_cases):
        print(f"\nTest Case {i+1}: Input: nums = {nums_test}, k = {k_test}")
        
        try:
            result = solver.findKthLargest(nums_test, k_test)
            print(f"Your Output: {result}")
            print(f"Expected:    {expected}")
            assert result == expected, "Assertion failed!"
            print("✅ Passed")
        except Exception as e:
            print(f"An error occurred: {e}")
            print("❌ Failed")