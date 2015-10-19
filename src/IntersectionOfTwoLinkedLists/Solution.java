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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here
        if(headA == null || headB == null){
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0;
        int lenB = 0;
        while(curA != null){
            curA = curA.next;
            lenA++;
        }
        while(curB != null){
            curB = curB.next;
            lenB++;
        }
        curA = headA;
        curB = headB;
        if(lenA < lenB){
            for(int i = 0; i < lenB - lenA; i++){
                curB = curB.next;
            }
        }else if(lenB < lenA){
            for(int i = 0; i < lenA -lenB; i++){
                curA = curA.next;
            }
        }
        while(curA != null){
            if(curA == curB){
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
        
    }  
}


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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode 
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Write your code here
        if(headA == null || headB == null){
            return null;
        }
        HashSet<ListNode> hs = new HashSet<ListNode>();
        ListNode curA = headA;
        while(curA != null){
            hs.add(curA);
            curA =curA.next;
        }
        ListNode curB = headB;
        while(curB != null){
            if(hs.contains(curB)){
                return curB;
            }
            curB = curB.next;
        }
        return null;
    }  
}
