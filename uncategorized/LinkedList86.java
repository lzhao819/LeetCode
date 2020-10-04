//86 Partition List
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
    public ListNode partition(ListNode head, int x) {
        if(head ==null || head.next==null) return head;
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode sCur = small;
        ListNode lCur = large;
        while(head!=null){
            if(head.val<x){
                sCur.next=head;
                sCur=sCur.next;
            }else{
                lCur.next=head;
                lCur=lCur.next;
            }
            head=head.next;
        }
        //connect two list
        sCur.next=large.next;
        lCur.next=null;
        return small.next;
    }
}