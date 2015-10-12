/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        int len = 0;
        ListNode cur = head;
        while(cur != null){
            len ++;
            cur = cur.next;
        }
        if(len == 0){
            return head;
        }
        k %= len;
        if(k == 0){
            return head;
        }
        
        ListNode fast = head;
        for(int i = 0; i < k ; i++){
            fast = fast.next;
        }
        cur = head;
        ListNode slow = head;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}
