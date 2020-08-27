//2 Add Two Numbers
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
//Time O(n)
//Space O(n)
class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode(0);
      ListNode newhead1 = l1;
      ListNode newhead2 = l2;
      int sum = 0;
      int addValue = 0;
      ListNode cur = dummy;
      while(newhead1!=null || newhead2!=null){
          int a = (newhead1!=null) ? newhead1.val : 0;
          int b = (newhead2!=null) ? newhead2.val : 0;
          sum = a + b + addValue;
          addValue = sum/10;
          cur.next = new ListNode(sum%10);
          cur = cur.next;
          if(newhead1!=null) newhead1 = newhead1.next;
          if(newhead2!=null) newhead2 = newhead2.next;
      }
      if(addValue>0){
          cur.next = new ListNode(addValue);
          cur = cur.next;
      }
      cur.next = null;
      return dummy.next;
  }
}
     