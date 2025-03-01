# Algo map leetcode questions
from typing import List

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