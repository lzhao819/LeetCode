//148 Sort List (Merge Sort)
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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        //find mid
        ListNode mid = findMid(head);
        ListNode midNext = mid.next;
        mid.next=null;
        //sort two half
        ListNode left = sortList(head);
        ListNode right = sortList(midNext);
        //merge two half
        return merge(left, right); 
    }
    
    private ListNode findMid(ListNode head){
        //use two pointer to find the middle node
        ListNode fptr = head;
        ListNode sptr = head;
        while(fptr.next!=null && fptr.next.next!=null){
          fptr=fptr.next.next;
          sptr=sptr.next;
        }
        return sptr;
      }//
    
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
       
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next; 
            }
            cur = cur.next;
        }
        
        if(l1!=null){
            cur.next = l1;   
        }else if(l2!=null){
            cur.next=l2;
        }
        
        return dummy.next; 
    }
}
