# Algo map leetcode questions
from typing import List

# Jewels and Stones
def numJewelsInStones(jewels: str, stones: str) -> int:
    # Time complexity = O(J + S)
    # Space complexity = O(J)
    s = set(jewels)
    output = 0

    for char in s:
        if char in stones:
            output += 1
    
    return output

# Contains Duplicate
def containsDuplicate(nums: List[int]) -> bool:
    # Time and Space complexity = O(n)
    num_set = set(nums)
    return len(num_set) != len(nums)

# Valid Anagram
def isAnagram(s: str, t: str) -> bool:
    # Time Complexity: O(N)
    # Space Complexity: O(N + M)
    if len(s) != len(t): return False

    s_dict = {}
    t_dict = {}

    for char in s:
        s_dict[char] = s_dict.get(char, 0) + 1
    
    for char in t:
        t_dict[char] = t_dict.get(char, 0) + 1

    for char, val in s_dict.items():
        if t_dict.get(char, 0) < val:
            return False
    
    return True