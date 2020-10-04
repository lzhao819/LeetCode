//141 Linked List Cycle
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode fptr = head;
        ListNode sptr = head;
        while(fptr.next!=null && fptr.next.next!=null){
            sptr = sptr.next;
            fptr = fptr.next.next;
            if(sptr == fptr) return true;
        }
        return false;
    }
}