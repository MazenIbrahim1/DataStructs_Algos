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