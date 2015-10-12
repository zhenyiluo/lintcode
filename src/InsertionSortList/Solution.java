/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = head;
        while(cur != null){
            ListNode tmp = dummyNode;
            while(tmp.next != null && tmp.next.val < cur.val){
                tmp = tmp.next;
            }
            ListNode insert = cur;
            cur = cur.next;
            insert.next = tmp.next;
            tmp.next = insert;
        }
        
        return dummyNode.next;
    }
}
