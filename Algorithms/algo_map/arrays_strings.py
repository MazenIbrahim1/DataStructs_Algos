# Algo map leetcode questions
from typing import List

# Number Closest to Zero
def findClosestNumber(nums: List[int]) -> int:
    # Time Complexity: O(n)
    # Space Complexity: O(1)
    if len(nums) == 1:
        return nums[0]
    
    result = nums[0]
    
    for num in nums:
        if abs(num) < abs(result):
            result = num
        elif abs(num) == abs(result):
            result = max(result, num)

    return result

# Merge Strings Alternately
def mergeAlternately(word1: str, word2: str) -> str:
    # Time Complexity: O(n)
    # Space Complexity: O(1)
    length = max(len(word1), len(word2))

    result = ""

    for i in range(length):
        if i >= len(word1):
            result += word1[i]
        elif i >= len(word2):
            result += word2[i]
        else:
            result += word2[i]
            result += word1[i]
    
    return result

# Roman to Integer
def romanToInt(s: str) -> int:
    # Time Complexity: O(n)
    # Space Complexity: O(1)
    romanDict = {
        "I": 1,
        "V": 5,
        "X": 10,
        "L": 50,
        "C": 100,
        "D": 500,
        "M": 1000
    }

    result = 0
    n = len(s)
    i = 0

    while i < n:
        if i < n - 1 and romanDict[s[i + 1]] > romanDict[s[i]]:
            diff = romanDict[s[i + 1]] - romanDict[s[i]]
            result += diff
            i += 2
        else:
            result += romanDict[s[i]]
            i += 1
    
    return result

# Is Subsequence
def isSubsequence(s: str, t: str) -> bool:
    # Time Complexity: O(n)
    # Space Complexity: O(1)
    if len(s) > len(t):
        return False
    if s == "":
        return True
    
    sub = 0
    strin = 0

    while sub < len(s) and strin < len(t):
        if s[sub] == t[strin]:
            sub += 1
        strin += 1
    
    return len(s) == sub

# Best Time to Buy and Sell Stock
def maxProfit(prices: List[int]) -> int:
    # Time Complexity: O(n)
    # Space Complexity: O(1)
    buy = float('inf')
    sell = 0

    for i in range(len(prices)):
        if prices[i] < buy:
            buy = prices[i]

        profit = prices[i] - buy
        if profit > sell:
            sell = profit

    return sell

# Longest Common Prefix
def longestCommonPrefix(strs: List[str]) -> str:
    # Check if strs list is given or empty
    if not strs:
        return ""
    
    min_length = float('inf')
    word = strs[0]

    for s in strs:
        if len(s) < min_length:
            min_length = len(s)
    
    i = 0

    while i < min_length:
        for s in strs:
            if s[i] != word[i]:
                return s[:i]
        i += 1

    return s[:i]

# Summary Ranges
def summaryRanges(nums: List[int]) -> List[str]:
    # Time and Space complexity: O(n)
    if len(nums) == 1:
        return [f"{nums[0]}"]

    ans = []
    i = 0

    while i < len(nums):
        start = nums[i]

        while i < len(nums) - 1 and nums[i] + 1 == nums[i+1]:
            i += 1

        if start != nums[i]:
            ans.append(str(start) + '->' + str(nums[i]))
        else:
            ans.append(str(nums[i]))
        
        i += 1
    
    return ans