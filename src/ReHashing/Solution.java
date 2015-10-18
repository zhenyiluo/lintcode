/**
 * Definition for ListNode
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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if(hashTable == null || hashTable.length == 0){
            return new ListNode[0];
        }
        
        int capacity = hashTable.length;
        int newCapacity = capacity * 2;
        ListNode[] newHashTable = new ListNode[newCapacity];
        for(int i = 0; i < capacity; i++){
            ListNode start = hashTable[i];
            while(start != null){
                int key = (start.val % newCapacity + newCapacity) % newCapacity;
                ListNode cur = newHashTable[key];
                ListNode newNode = new ListNode(start.val);
                if(cur == null){
                    newHashTable[key] = newNode;
                }else{
                    while(cur.next != null){
                        cur = cur.next;
                    }
                    cur.next = newNode;
                }
                
                start = start.next;
            }
        }
        return newHashTable;
    }
};

