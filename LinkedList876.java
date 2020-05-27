//876 Middle of the Linked List
//two pointers
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        if(head ==null) return head;
        ListNode fptr = head;
        ListNode sptr = head;
        while(fptr.next!=null && fptr.next.next!=null){
            sptr = sptr.next;
            fptr = fptr.next.next;   
        }
        if(fptr.next==null){
            return sptr;
        }
        return sptr.next; 
    }
}