//142 Linked List Cycle II
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
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode fptr = head;
        ListNode sptr = head;
        while(fptr.next!=null && fptr.next.next!=null){
            sptr = sptr.next;
            fptr = fptr.next.next;
            if(sptr == fptr) {
                fptr = head;
                while(fptr!=sptr){
                    fptr=fptr.next;
                    sptr=sptr.next;
                }
                return sptr;
            }
        }
        return null;
    }
}