# ============================================================================
# PROBLEM DESCRIPTION:
# ============================================================================
#
# LeetCode 20: Valid Parentheses
#
# Given a string `s` containing just the characters '(', ')', '{', '}', '['
# and ']', determine if the input string is valid.
#
# An input string is valid if:
# 1. Open brackets must be closed by the same type of brackets.
# 2. Open brackets must be closed in the correct order.
# 3. Every close bracket has a corresponding open bracket of the same type.
#
# Example 1:
#   Input: s = "()"
#   Output: true
#
# Example 2:
#   Input: s = "()[]{}"
#   Output: true
#
# Example 3:
#   Input: s = "(]"
#   Output: false
#
# ============================================================================

class Solution:
    """
    Solves the Valid Parentheses problem.
    """
    def isValid(self, s: str) -> bool:

        # dict of closing to opening brackets
        bracket_map = {"}": "{", ")": "(", "]": "["}
        # creating a stack from a list
        stack = []
        # loop through s
        for char in s:
            # If the character is a closing bracket
            if char in bracket_map:
                # if stack is not empty
                if stack:
                    # check top element
                    top_element = stack.pop()
                # stack was empty, therefore closing bracket has no match. set to junk we fail here
                else: 
                    top_element = 'junk'    
                # compare top element against expected value. Should be opening bracket
                if bracket_map[char] != top_element:
                    return False
            # not a closing bracket, add it to stack
            else:
                stack.append(char)
        # after looping, stack should be empty, otherwise that means there is unclosed opening brackets
        return not stack


# ============================================================================
# TEST CASES (Do not modify)
# ============================================================================
if __name__ == '__main__':
    solver = Solution()
    
    print("--- Testing Valid Parentheses ---")
    
    test_cases = [
        ("()", True),
        ("()[]{}", True),
        ("(]", False),
        ("([)]", False),
        ("{[]}", True),
        ("]", False),
        ("(", False),
        ("", True)
    ]
    
    for i, (s_test, expected) in enumerate(test_cases):
        print(f"\nTest Case {i+1}: Input: s = '{s_test}'")
        
        try:
            result = solver.isValid(s_test)
            print(f"Your Output: {result}")
            print(f"Expected:    {expected}")
            assert result == expected, "Assertion failed!"
            print("✅ Passed")
        except Exception as e:
            print(f"An error occurred: {e}")
            print("❌ Failed")