"""
Definition of ListNode
class ListNode(object):

    def __init__(self, val, next=None):
        self.val = val
        self.next = next
"""
class Solution:
    """
    @param head: The first node of the linked list.
    @return: The node where the cycle begins. 
                if there is no cycle, return null
    """
    def detectCycle(self, head):
        # write your code here
        if head is None:
            return None
        
        slow = head
        fast = head
        
        found = False
        
        while fast.next is not None and fast.next.next is not None:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                found = True
                break
            
            
        if not found:
            return None
        
        fast = head
        
        while slow != fast:
            slow = slow.next
            fast = fast.next
        
        return slow
