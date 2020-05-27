//92 Reverse Linked List II
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
//画图分析！
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        
        ListNode prev = dummy; //mark the node before reversing
        for(int i=0; i<m-1;i++) prev = prev.next;
        
        ListNode start = prev.next;//a pointer to start of a sub-list that will be reversed
        ListNode then = start.next;//a pointer to a node that will be reversed
        
        //moving and inserting then between pre and pre.next.
        //keep making start.next point to then.next to insure it's always pointing to the tail part of the list.
        for(int i=0; i<n-m; i++){
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;   
        }
        return dummy.next;
    }
}