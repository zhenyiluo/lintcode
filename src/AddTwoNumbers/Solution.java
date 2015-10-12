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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode ret = new ListNode(-1);
        ListNode cur = ret;
        int carryOver = 0;
        while(l1 != null || l2 != null){
            int val = carryOver;
            if(l1 != null){
                val += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                val += l2.val;
                l2 = l2.next;
            }
            carryOver = val / 10;
            val = val % 10;
            cur.next = new ListNode(val);
            cur = cur.next;
        }
        
        if(carryOver != 0){
            cur.next = new ListNode(carryOver);
        }
        
        return ret.next;
    }
}
