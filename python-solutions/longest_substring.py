# ============================================================================
# PROBLEM DESCRIPTION:
# ============================================================================
#
# LeetCode 3: Longest Substring Without Repeating Characters
#
# Given a string `s`, find the length of the longest substring without
# repeating characters.
#
# Example 1:
#   Input: s = "abcabcbb"
#   Output: 3
#   Explanation: The answer is "abc", with the length of 3.
#
# Example 2:
#   Input: s = "bbbbb"
#   Output: 1
#   Explanation: The answer is "b", with the length of 1.
#
# Example 3:
#   Input: s = "pwwkew"
#   Output: 3
#   Explanation: The answer is "wke", with the length of 3.
#   Notice that the answer must be a substring, "pwke" is a subsequence
#   and not a substring.
#
# ============================================================================

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # =================================================================
        # YOUR CODE GOES HERE
        #
        # Hints:
        # 1. This is a perfect problem for the "sliding window" technique,
        #    which uses two pointers (e.g., `left` and `right`).
        #
        # 2. You need a way to efficiently track the characters currently
        #    inside your "window" (from `left` to `right`). A dictionary
        #    (hash map) or a set is ideal for this.
        #
        # 3. The `right` pointer expands the window by moving forward. The
        #    `left` pointer shrinks the window when a repeat character is found.
        #
        # 4. A powerful way to use a dictionary is to store the most recent
        #    index of each character: `char_map = {character: index}`.
        #
        # 5. When the `right` pointer encounters a character that is already
        #    in `char_map`, it means you have a repeat. How should you move
        #    the `left` pointer to ensure the window is valid again? You
        #    can't just do `left += 1`. You might need to jump `left` forward.
        # =================================================================
        max_substring_size = 0
        unique_chars = set()
        left = 0
        right = 0
        # loop through characters
        for right in range(len(s)):
            # if repeat letter found, move left sliding window and remove values from set
            while s[right] in unique_chars:
                unique_chars.remove(s[left])
                left += 1
            # window is valid add letter to set and update max size
            unique_chars.add(s[right])
            max_substring_size = max(max_substring_size, len(unique_chars))
            
        return max_substring_size

# ============================================================================
# TEST CASES (Do not modify)
# ============================================================================
if __name__ == '__main__':
    solver = Solution()

    print("--- Testing Longest Substring Without Repeating Characters ---")

    test_cases = [
        ("abcabcbb", 3),
        ("bbbbb", 1),
        ("pwwkew", 3),
        ("", 0),
        (" ", 1),
        ("au", 2),
        ("dvdf", 3)
    ]

    for i, (s_test, expected) in enumerate(test_cases):
        print(f"\nTest Case {i+1}: Input: s = '{s_test}'")
        
        try:
            result = solver.lengthOfLongestSubstring(s_test)
            print(f"Your Output: {result}")
            print(f"Expected:    {expected}")
            assert result == expected, "Assertion failed!"
            print("✅ Passed")
        except Exception as e:
            print(f"An error occurred: {e}")
            print("❌ Failed")