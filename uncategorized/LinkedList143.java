//143 Reorder List
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
    public void reorderList(ListNode head) {
        if(head == null || head.next==null) return;
        
        //find middel node
        ListNode head1 = head;
        ListNode head2 = head;
        ListNode mid = middleNode(head);
        //split from mid
        head2=mid.next;
        mid.next=null;
        //reverse head2
        head2 = reverse(head2);
        //merge two list
        head = merge(head1, head2);
        return;
      }

      private ListNode middleNode(ListNode head){
        //use two pointer to find the middle node
        ListNode fptr = head;
        ListNode sptr = head;
        while(fptr.next!=null && fptr.next.next!=null){
          fptr=fptr.next.next;
          sptr=sptr.next;
        }
        return sptr;
      }//

      private ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode prev = null;
        while(head!=null){
          ListNode next = head.next;
          head.next=prev;
          prev=head;
          head=next;
        }
        return prev;
      }//

      private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1!=null && l2!=null){
          cur.next=l1;
          l1=l1.next;
          cur=cur.next;
          cur.next=l2;
          l2=l2.next;
          cur=cur.next;
        }
        if(l1!=null){
          cur.next=l1;
        }else{
          cur.next=l2;
        }
        return dummy.next;
      }//
}