# Algo map leetcode questions
from collections import defaultdict
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
    # Space Complexity: O(N + M) = O(N)
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

# Maximum Number of Balloons
def maxBalloons(text: str) -> int:
    if len(text) < 7: return 0
    
    balloon = 'balloon'
    counter = defaultdict(int)

    for char in text:
        if char in balloon:
            counter[char] += 1
    
    if any(char not in counter for char in balloon):
        return 0
    else:
        return min(counter['a'], counter['b'], counter['n'], counter['l']//2, counter['o']//2)
    
# Two Sum
def twoSum(arr: List[int], target: int) -> List[int]:
    numMap = {}

    for i in range(len(arr)):
        complement = target - arr[i]
        if complement in numMap:
            return [numMap[complement], i]
        numMap[arr[i]] = i
    
    return []

