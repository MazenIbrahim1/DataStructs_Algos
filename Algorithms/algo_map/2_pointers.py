# Algo map leetcode questions
from typing import List

# Sorted Squares
def sortedSquares(nums: List[int]) -> List[int]:
    # Time complexity: O(n)
    # Space complexity: O(n)
    left = 0
    right = len(nums) - 1
    result = []

    while left <= right:
        if (nums[right] ** 2) > (nums[left] ** 2):
            result.append(nums[right] ** 2)
            right -= 1
        else:
            result.append(nums[left] ** 2)
            left += 1

    result.reverse()
    return result

# Reverse a string
def reverseString(s: List[str]) -> None:
    # Time complexity: O(n)
    # Space complexity: O(1)
    left = 0
    right = len(s) - 1

    while left < right:
        s[left], s[right] = s[right], s[left]
        left += 1
        right -=1

# Two Sum
def TwoSum(numbers: List[int], target: int) -> List[int]:
    # Time complexity: O(n)
    # Space complexity: O(1)
    if numbers is None:
        return []

    left, right = 0, len(numbers) - 1

    while left < right:
        if numbers[left] + numbers[right] < target:
            left += 1
        elif numbers[left] + numbers[right] > target:
            right -= 1
        else:
            return [left + 1, right + 1]