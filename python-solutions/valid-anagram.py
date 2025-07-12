from collections import Counter

# ============================================================================
# PROBLEM DESCRIPTION:
# ============================================================================
#
# LeetCode 242: Valid Anagram
#
# Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`,
# and `false` otherwise.
#
# An Anagram is a word or phrase formed by rearranging the letters of a
# different word or phrase, typically using all the original letters
# exactly once.
#
# Example 1:
#   Input: s = "anagram", t = "nagaram"
#   Output: true
#
# Example 2:
#   Input: s = "rat", t = "car"
#   Output: false
#
# ============================================================================

class Solution:
    """
    Solves the Valid Anagram problem.
    """
    def isAnagram(self, s: str, t: str) -> bool:
        # Anagrams must have the same length. This is a quick check
        # to fail early if they don't.
        if len(s) != len(t):
            return False

        # This is the most Pythonic way to solve this problem.
        # `collections.Counter` is a dictionary subclass that automatically
        # counts the occurrences of each item in an iterable (like a string).
        #
        # For s = "anagram", Counter(s) becomes:
        # Counter({'a': 3, 'n': 1, 'g': 1, 'r': 1, 'm': 1})
        #
        # We can then simply compare the two Counter objects. They are equal
        # if and only if they have the same characters with the same counts.
        # This is an O(N) solution, where N is the length of the strings.
        
        return Counter(s) == Counter(t)
        # --- ALTERNATIVE SOLUTION (also Pythonic, but less efficient) ---
        #
        # You could also solve this by sorting both strings and comparing them.
        # This works but is generally O(N log N) due to the sorting step.
        #
        # return sorted(s) == sorted(t)


# ============================================================================
# TEST CASES
# ============================================================================
# This block allows you to run the file directly to test the solution.
if __name__ == '__main__':
    solver = Solution()

    print("--- Testing Valid Anagram ---")

    test_cases = [
        ("anagram", "nagaram", True),
        ("rat", "car", False),
        ("a", "ab", False),
        ("listen", "silent", True),
        ("", "", True) # Edge case: empty strings are anagrams of each other
    ]

    for i, (s_test, t_test, expected) in enumerate(test_cases):
        print(f"\nTest Case {i+1}:")
        print(f"Input: s = '{s_test}', t = '{t_test}'")
        
        result = solver.isAnagram(s_test, t_test)
        
        print(f"Output: {result}")
        print(f"Expected: {expected}")
        assert result == expected, f"Assertion failed for test case {i+1}"
        print("✅ Passed")