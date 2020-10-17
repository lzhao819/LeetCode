//206 Reverse Linked List
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
//Iteration
class SolutionI {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev; 
    }
}

//recursion
class SolutionII {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return next;   
    }
}