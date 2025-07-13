from typing import List
from collections import defaultdict

# ============================================================================
# PROBLEM DESCRIPTION:
# ============================================================================
#
# LeetCode 49: Group Anagrams
#
# Given an array of strings `strs`, group the anagrams together. You can
# return the answer in any order.
#
# An Anagram is a word or phrase formed by rearranging the letters of a
# different word or phrase, typically using all the original letters
# exactly once.
#
# Example 1:
#   Input: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
#   Output: [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]
#
# Example 2:
#   Input: strs = [""]
#   Output: [[""]]
#
# Example 3:
#   Input: strs = ["a"]
#   Output: [["a"]]
#
# ============================================================================

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # =================================================================
        # YOUR CODE GOES HERE
        #
        # Hints:
        # 1. The core idea is to use a dictionary (hash map) where the anagrams
        #    are grouped together. What property do all anagrams share?
        #
        # 2. If you sort the letters of "eat", "tea", and "ate", they all
        #    become "aet". This sorted version can serve as a "canonical"
        #    representation for the anagram group.
        #
        # 3. Can you use this canonical representation as a key in your dictionary?
        #    The value associated with this key would be a list of the original
        #    strings that belong to that group.
        #
        # 4. Remember that dictionary keys must be immutable. A sorted string is
        #    fine, but a sorted list of characters is not. `tuple(sorted(word))`
        #    is a common pattern to create an immutable key.
        #
        # 5. Power-user tip: `collections.defaultdict(list)` can simplify the
        #    code by automatically creating an empty list for new keys.
        # =================================================================

        # # my solution
        # # dict with k being sorted string and v being list of strings that match
        # string_map = {}
        
        # for word in strs:
        #     # gets key. tuple is used b/c sorted returns mutable char list, need immutable. 
        #     # ex. ['eat'] = ('a', 'e', 't')
        #     key = tuple(sorted(word))
        #     # if key does not exist in map yet, insert k,v pair with v being singletonlist of word
        #     if key not in string_map:
        #         string_map[key] = [word]
        #     # if key does exist, append word to existing list
        #     else:
        #         string_map[key].append(word)

        # # concise way to get all values from dict
        # return list(string_map.values())

        # pythonic solution using defaultdict
        # Create a defaultdict where the default value for a new key is an empty list
        anagram_map = defaultdict(list)

        for word in strs:
            key = tuple(sorted(word))
        
            # This one line handles both cases!
            # - If `key` is new, it creates `anagram_map[key] = []` and then appends.
            # - If `key` exists, it just appends to the existing list.
            anagram_map[key].append(word)

        return list(anagram_map.values())

# ============================================================================
# TEST CASES (Do not modify)
# ============================================================================
if __name__ == '__main__':
    solver = Solution()

    print("--- Testing Group Anagrams ---")

    test_cases = [
        (["eat", "tea", "tan", "ate", "nat", "bat"], [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]),
        ([""], [[""]]),
        (["a"], [["a"]]),
        (["cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"], 
         [["max"], ["buy"], ["doc"], ["may"], ["ill"], ["duh"], ["tin"], ["bar"], ["pew"], ["cab"]])
    ]

    # Helper function to compare lists of lists without regard to order
    def compare_lists(l1, l2):
        if len(l1) != len(l2):
            return False
        # Sort each inner list, then sort the outer list of tuples
        s1 = sorted(tuple(sorted(inner)) for inner in l1)
        s2 = sorted(tuple(sorted(inner)) for inner in l2)
        return s1 == s2

    for i, (strs_test, expected) in enumerate(test_cases):
        print(f"\nTest Case {i+1}: Input: strs = {strs_test}")
        
        try:
            result = solver.groupAnagrams(strs_test)
            print(f"Your Output: {result}")
            print(f"Expected (any order): {expected}")
            assert compare_lists(result, expected), "Assertion failed!"
            print("✅ Passed")
        except Exception as e:
            print(f"An error occurred: {e}")
            print("❌ Failed")