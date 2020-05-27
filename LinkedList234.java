//234 Palindrome Linked List
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
    public boolean isPalindrome(ListNode head) {
        //find middle node
        if(head==null || head.next == null) return true;
        ListNode mid = findMid(head);
        ListNode midNext = reverse(mid.next);
        while(midNext!=null){
          if(head.val != midNext.val){
            return false;
          }
          head = head.next;
          midNext = midNext.next;
        }
        return true;  
      }

      private ListNode findMid(ListNode head){
        ListNode sptr = head;
        ListNode fptr = head;
        while(fptr.next!=null && fptr.next.next!=null){
          sptr=sptr.next;
          fptr=fptr.next.next;
        }
        return sptr;
      }

      private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head!=null){
          ListNode next=head.next;
          head.next = prev;
          prev = head;
          head = next;
        }
        return prev;
      }
}