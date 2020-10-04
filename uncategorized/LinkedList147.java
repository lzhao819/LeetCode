//147 Insertion Sort List
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
    public ListNode insertionSortList(ListNode head) {
        if( head == null ){
			return head;
		}
		
		ListNode dummy = new ListNode(0); //new starter of the sorted list
		ListNode cur = head; //the node will be inserted
		ListNode prev = dummy; //insert node between prev and prev.next
		ListNode next = null; //the next node will be inserted
		//not the end of input list
		while( cur != null ){
			next = cur.next;
			//find the right place to insert
			while( prev.next != null && prev.next.val < cur.val ){
				prev = prev.next;
			}
			//insert between pre and pre.next
			cur.next = prev.next;
			prev.next = cur;
            prev = dummy;
			cur = next;
		}
		
		return dummy.next;
    }
}

//更优的解
public ListNode insertionSortList(ListNode head) {
     ListNode dummy = new ListNode(0);
     ListNode prev = dummy;

    while (head != null) {
        ListNode temp = head.next;
        
        /* Before insert, the prev is at the last node of the sorted list.
           Only the last node's value is larger than the current inserting node 
           should we move the temp back to the head*/
        if (prev.val >= head.val) prev = dummy;

        while (prev.next != null && prev.next.val < head.val) {
            prev = prev.next;
        }
        
        head.next = prev.next;
        prev.next = head;
        head = temp;
    }
    return dummy.next;
}