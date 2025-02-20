# Algo map leetcode questions
from typing import List

# Number Closest to Zero
def findClosestNumber(nums: List[int]) -> int:
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

# Best Time to Buy and Sell Stock
def maxProfit(prices: List[int]) -> int:
    buy = float('inf')
    sell = 0

    for i in range(len(prices)):
        if prices[i] < buy:
            buy = prices[i]

        profit = prices[i] - buy
        if profit > sell:
            sell = profit

    return sell