# ============================================================================
# PROBLEM DESCRIPTION:
# ============================================================================
#
# LeetCode 205: Isomorphic Strings
#
# Given two strings `s` and `t`, determine if they are isomorphic.
#
# Two strings `s` and `t` are isomorphic if the characters in `s` can be
# replaced to get `t`.
#
# All occurrences of a character must be replaced with another character while
# preserving the order of characters. No two characters may map to the same
# character, but a character may map to itself.
#
# Example 1:
#   Input: s = "egg", t = "add"
#   Output: true (e -> a, g -> d)
#
# Example 2:
#   Input: s = "foo", t = "bar"
#   Output: false (o maps to a, then o tries to map to r. Invalid)
#
# Example 3:
#   Input: s = "paper", t = "title"
#   Output: true (p -> t, a -> i, e -> l, r -> e)
#
# Example 4:
#   Input: s = "badc", t = "baba"
#   Output: false (d maps to b, but a already maps to b. Invalid one-to-one mapping)
#
# ============================================================================

class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        # =================================================================
        # YOUR CODE GOES HERE
        #
        # Hints:
        # 1. You need to maintain a mapping from characters in `s` to characters
        #    in `t`. A dictionary is perfect for this. `s_to_t_map = {}`.
        #
        # 2. Iterate through both strings simultaneously. `zip` is a great
        #    Python tool for this: `for char_s, char_t in zip(s, t):`.
        #
        # 3. For each pair of characters, check your mapping.
        #    - If `char_s` is already in the map, does its value match `char_t`?
        #      If not, they can't be isomorphic.
        #    - If `char_s` is NOT in the map, you need to create a new mapping.
        #
        # 4. THE CRITICAL RULE: "No two characters may map to the same character".
        #    When you create a new mapping (`s_to_t_map[char_s] = char_t`), how
        #    can you ensure that `char_t` hasn't already been used as a mapping
        #    for a *different* character in `s`? You will likely need a second
        #    data structure (like a set) to keep track of the mapped values in `t`.
        # =================================================================

        s_to_t_map = {}
        t_mapped = set()
        # loop through both strings using zip
        for char_s, char_t in zip(s, t):
            # if s exists in map
            if char_s in s_to_t_map:
                # if s -> t value does not equal current t value, not isomorphic
                if s_to_t_map.get(char_s) != char_t:
                    return False
            # if s does not have mapping
            else:
                # if a mapping has already been created for t, then not isomorphic
                # because two chars can't map to same char
                if char_t in t_mapped:
                    return False
                t_mapped.add(char_t)
                s_to_t_map[char_s] = char_t
        return True
        


# ============================================================================
# TEST CASES (Do not modify)
# ============================================================================
if __name__ == '__main__':
    solver = Solution()

    print("--- Testing Isomorphic Strings ---")

    test_cases = [
        ("egg", "add", True),
        ("foo", "bar", False),
        ("paper", "title", True),
        ("badc", "baba", False), # Critical test case for one-to-one mapping
        ("ab", "aa", False),      # Another one-to-one mapping failure
        ("a", "b", True),
        ("", "", True)
    ]

    for i, (s_test, t_test, expected) in enumerate(test_cases):
        print(f"\nTest Case {i+1}: Input: s = '{s_test}', t = '{t_test}'")
        
        try:
            result = solver.isIsomorphic(s_test, t_test)
            print(f"Your Output: {result}")
            print(f"Expected:    {expected}")
            assert result == expected, "Assertion failed!"
            print("✅ Passed")
        except Exception as e:
            print(f"An error occurred: {e}")
            print("❌ Failed")