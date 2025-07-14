from typing import List, Optional

# ============================================================================
# HELPER CLASS (Definition of a singly-linked list node)
# ============================================================================
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

# ============================================================================
# PROBLEM DESCRIPTION:
# ============================================================================
#
# LeetCode 206: Reverse Linked List
#
# Given the `head` of a singly linked list, reverse the list, and return
# the new head of the reversed list.
#
# Example 1:
#   Input: head = [1, 2, 3, 4, 5]
#   Output: [5, 4, 3, 2, 1]
#
# Example 2:
#   Input: head = [1, 2]
#   Output: [2, 1]
#
# Example 3:
#   Input: head = []
#   Output: []
#
# ============================================================================

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # =================================================================
        # YOUR CODE GOES HERE
        #
        # Hints:
        # 1. You need to iterate through the list, but at each node, you will
        #    change its `next` pointer to point to the *previous* node.
        #
        # 2. You will need three pointers to keep track of things as you traverse:
        #      a) `prev`: The node that came before the current one.
        #      b) `current`: The node you are currently looking at.
        #
        # 3. What should `prev` be initialized to? The original head's new
        #    `next` will be `None`, so `prev` should start as `None`.
        #
        # 4. The loop logic is critical. In each step:
        #      - First, save the `next` node before you break the link.
        #        (e.g., `temp_next = current.next`)
        #      - Then, rewire the pointer: `current.next = prev`
        #      - Finally, move your `prev` and `current` pointers forward for
        #        the next iteration.
        #
        # 5. When the loop ends, `current` will be `None`. What will `prev` be?
        # =================================================================

        # initialize two main pointers
        prev = None
        current = head

        # loop until current is not None
        while current:
            #  prev   curr   next
            #   |      |      |
            #  None   [1] -> [2] -> [3] -> None
            # 1. Save the next node BEFORE we change any pointers
            next_node = current.next

            #  prev   curr   next
            #   |      |      |
            # None <- [1]   [2] -> [3] -> None
            # 2. reverse our current to point the other way
            current.next = prev

            #         prev  curr
            #          |     |     
            # None <- [1]   [2] -> [3] -> None
            # 3. move pointers one step forward
            prev = current
            current = next_node

        # loop is finished, prev would be the new head of linked list (last element in original linked list)
        return prev

# ============================================================================
# TEST CASES (Do not modify)
# ============================================================================
# Helper functions to convert between Python list and our ListNode
def create_linked_list(items: List) -> Optional[ListNode]:
    if not items:
        return None
    head = ListNode(items[0])
    current = head
    for item in items[1:]:
        current.next = ListNode(item)
        current = current.next
    return head

def linked_list_to_list(head: Optional[ListNode]) -> List:
    items = []
    current = head
    while current:
        items.append(current.val)
        current = current.next
    return items

if __name__ == '__main__':
    solver = Solution()

    print("--- Testing Reverse Linked List ---")

    test_cases = [
        ([1, 2, 3, 4, 5], [5, 4, 3, 2, 1]),
        ([1, 2], [2, 1]),
        ([], []),
        ([42], [42])
    ]

    for i, (input_list, expected_list) in enumerate(test_cases):
        print(f"\nTest Case {i+1}: Input: {input_list}")
        
        # Create a linked list from the input
        head = create_linked_list(input_list)
        
        try:
            # Get the reversed head from the solution
            reversed_head = solver.reverseList(head)
            # Convert the result back to a list for comparison
            result_list = linked_list_to_list(reversed_head)
            
            print(f"Your Output: {result_list}")
            print(f"Expected:    {expected_list}")
            assert result_list == expected_list, "Assertion failed!"
            print("✅ Passed")
        except Exception as e:
            print(f"An error occurred: {e}")
            print("❌ Failed")