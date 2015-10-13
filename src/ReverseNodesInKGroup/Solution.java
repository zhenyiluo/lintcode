/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here
        if(k <= 0){
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        int count = 0;
        ListNode p = head;
        while(p != null){
            count++;
            p = p.next;
        }
        
        p = dummyNode;
        while(count >= k){
            count -= k;
            p.next = reverse(p.next, k);
            for(int i = 0; i < k; i++){
                p = p.next;
            }
        }
        
        return dummyNode.next;
    }
    
    private ListNode reverse(ListNode head, int k){
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = head;
        for(int i = 0; i < k; i++){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head.next = cur;
        return prev;
    }
}
