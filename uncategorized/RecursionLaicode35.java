//Laicode 35 Reverse Linked List In Pairs
//Medium
// Reverse pairs of elements in a singly-linked list.

// Examples

// L = null, after reverse is null
// L = 1 -> null, after reverse is 1 -> null
// L = 1 -> 2 -> null, after reverse is 2 -> 1 -> null
// L = 1 -> 2 -> 3 -> null, after reverse is 2 -> 1 -> 3 -> null

/**
 * class ListNode {
 *   public int value;
 *   public ListNode next;
 *   public ListNode(int value) {
 *     this.value = value;
 *     next = null;
 *   }
 * }
 */
public class Solution {
  //Method1: recursive
  public ListNode reverseInPairsI(ListNode head) {
    if(head==null||head.next==null){
      return head;
    }
    ListNode next=head.next;
    head.next=reverseInPairs(head.next.next);
    next.next=head;
    return next;
  }
  //Method2: Iterative
  public ListNode reverseInPairsII(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode cur = dummy;
    while(cur.next!=null && cur.next.next!=null){
      ListNode next = cur.next.next;
      cur.next.next=cur.next.next.next;
      next.next = cur.next;
      cur.next=next;
      cur=cur.next.next;
    }
    return dummy.next;
  }
}
