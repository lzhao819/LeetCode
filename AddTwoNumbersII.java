//445 Add Two Numbers II
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //Method 1
        //reverse the input LinkedList
        //then used the method in Add Two Numbers
        
        //Method2: using stack to reverse linkedList
        Deque<Integer> s1 = new LinkedList<>();
        Deque<Integer> s2 = new LinkedList<>();
        while(l1!=null){
            s1.offerFirst(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            s2.offerFirst(l2.val);
            l2=l2.next;
        }
        int sum = 0;
        ListNode dummy = null;
        while(!s1.isEmpty() || !s2.isEmpty() ||  sum != 0) {
            int value1 = s1.isEmpty() ? 0 : s1.pollFirst();
            int value2 = s2.isEmpty() ? 0 : s2.pollFirst();
            sum = value1 + value2 + sum;
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = dummy;
            dummy = newNode;
            sum = sum/10; 
        }
        return dummy;   
    }
}