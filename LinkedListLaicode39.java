//Laicode39 Insert In Sorted Linked List
// Insert a value in a sorted linked list.

// Examples

// L = null, insert 1, return 1 -> null
// L = 1 -> 3 -> 5 -> null, insert 2, return 1 -> 2 -> 3 -> 5 -> null
// L = 1 -> 3 -> 5 -> null, insert 3, return 1 -> 3 -> 3 -> 5 -> null
// L = 2 -> 3 -> null, insert 1, return 1 -> 2 -> 3 -> null
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
  public ListNode insert(ListNode head, int value) {
    ListNode target = new ListNode(value);
    //determine if insert before head
    if(head == null || head.value >= value){
      target.next = head;
      return target;
    } 
    ListNode prev = head;
    while(prev.next != null && prev.next.value<value){
      prev = prev.next;
    }
    target.next = prev.next;
    prev.next=target;
    return head;
  }
}