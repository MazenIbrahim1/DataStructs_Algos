# Algo map leetcode questions
from typing import List

# Baseball Game
def calPoints(operations: List[str]) -> int:
    # Time and Space complexity = O(n)
    record = []
    score = 0

    for operation in operations:
        if operation == 'C':
            prev = record.pop()
            score -= prev
        elif operation == 'D':
            new_score = int(record[-1]) * 2
            record.append(new_score)
            score += new_score
        elif operation == '+':
            new_score = int(record[-1]) + int(record[-2])
            record.append(new_score)
            score += new_score
        else:
            record.append(int(operation))
            score += int(operation)
    
    return score

# Valid Parentheses
def isValid(s: str) -> bool:
    # Time and Space complexity = O(n)
    stack = []

    for char in s:
        if char in "({[":
            stack.append(char)
        else:
            if not stack or \
                (char == ')' and stack[-1] != '(') or \
                (char == '}' and stack[-1] != '{') or \
                (char == ']' and stack[-1] != '['):
                    return False
            stack.pop()
    
    return not stack
