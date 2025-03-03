# Algo map leetcode questions
from typing import List, Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

# Delete Duplicates
def deleteDuplicates(head: Optional[ListNode]) -> Optional[ListNode]:
    # Time Complexity: O(n)
    # Space Complexity: O(1)
    cursor = head

    while cursor and cursor.next:
        if cursor.val == cursor.next.val:
            cursor.next = cursor.next.next
        else:
            cursor = cursor.next
    
    return head

# Reverse Linked List
def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
    pass