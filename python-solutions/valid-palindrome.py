# ============================================================================
# PROBLEM DESCRIPTION:
# ============================================================================
#
# LeetCode 125: Valid Palindrome
#
# A phrase is a palindrome if, after converting all uppercase letters into
# lowercase letters and removing all non-alphanumeric characters, it reads
# the same forward and backward. Alphanumeric characters include letters
# and numbers.
#
# Given a string `s`, return `true` if it is a palindrome, or `false` otherwise.
#
# Example 1:
#   Input: s = "A man, a plan, a canal: Panama"
#   Output: true
#   Explanation: "amanaplanacanalpanama" is a palindrome.
#
# Example 2:
#   Input: s = "race a car"
#   Output: false
#   Explanation: "raceacar" is not a palindrome.
#
# Example 3:
#   Input: s = " "
#   Output: true
#   Explanation: s is an empty string "" after removing non-alphanumeric
#   characters. An empty string reads the same forward and backward.
#
# ============================================================================

class Solution:
    def isPalindrome(self, s: str) -> bool:
        # =================================================================
        # YOUR CODE GOES HERE
        #
        # Hints:
        # 1. The two-pointer technique is ideal here. Initialize a left
        #    pointer at the start of the string and a right pointer at the end.
        #
        # 2. Move the pointers toward each other. In each step, you need to
        #    handle non-alphanumeric characters. How do you "skip" them?
        #    Python's string methods like `.isalnum()` will be very useful.
        #
        # 3. Don't forget to handle character casing. `.lower()` is your friend.
        #
        # 4. At what condition do you know the string is NOT a palindrome?
        #    When do the pointers stop?
        # =================================================================

        # # my solution, java-coded
        # left = 0
        # right = len(s) - 1
        # while left < right:
        #     if s[left].isalnum():
        #         if s[right].isalnum():
        #             if s[left].lower() == s[right].lower():
        #                 right -= 1
        #                 left += 1
        #                 continue
        #             else:
        #                 return False
        #         else:
        #             right -= 1
        #     else:
        #         left += 1
        # return True

        # # pythonized solution
        # while left < right:
        #     # Step 1: Find the next valid character from the left.
        #     if not s[left].isalnum():
        #         left += 1
        #         continue 

        #     # Step 2: Find the next valid character from the right.
        #     if not s[right].isalnum():
        #         right -= 1
        #         continue

        #     # --- At this point, we KNOW we have two valid characters ---
            
        #     # Step 3: Compare them. If not equal then mismatch, therefore not palindrome
        #     if s[left].lower() != s[right].lower():
        #         return False  

        #     # Step 4: If they match, move both pointers inward.
        #     left += 1
        #     right -= 1

        # # If the loop completes without finding a mismatch, it's a palindrome.
        # return True
    
        # super pythonic solution, uses O(n) more space because of creation of cleaned_s
        # 1. Create a new string with only lowercase alphanumeric characters.
        # This uses a generator expression inside "".join(), which is very efficient.
        cleaned_s = "".join(char.lower() for char in s if char.isalnum())
    
        # 2. Check if the cleaned string is equal to its reverse.
        #    The `[::-1]` slice is the classic Python way to reverse a string.
        return cleaned_s == cleaned_s[::-1]

# ============================================================================
# TEST CASES (Do not modify)
# ============================================================================
if __name__ == '__main__':
    solver = Solution()

    print("--- Testing Valid Palindrome ---")

    test_cases = [
        ("A man, a plan, a canal: Panama", True),
        ("race a car", False),
        (" ", True),
        ("0P", False),
        ("Was it a car or a cat I saw?", True),
        ("level", True)
    ]

    for i, (s_test, expected) in enumerate(test_cases):
        print(f"\nTest Case {i+1}: Input: s = '{s_test}'")
        
        try:
            result = solver.isPalindrome(s_test)
            print(f"Your Output: {result}")
            print(f"Expected:    {expected}")
            assert result == expected, "Assertion failed!"
            print("✅ Passed")
        except Exception as e:
            print(f"An error occurred: {e}")
            print("❌ Failed")