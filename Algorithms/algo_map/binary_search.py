# Algo map leetcode questions
from typing import List

# Binary Search
def binary_search(nums: List[int], target: int) -> int:
    # Time Complexity: O(log n)
    # Space Complexity: O(1)
    if not nums: return -1

    left, right = 0, len(nums) - 1

    while left <= right:
        mid = (left + right) // 2
        if nums[mid] == target:
            return mid
        elif nums[mid] > target:
            right = mid - 1
        else:
            left = mid + 1
    
    return -1