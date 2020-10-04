public class DeleteNodeinLinkedList {
    public ListNode deleteNode(ListNode head, int val) {
        if(head==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        if(head.val==val){
            dummy.next = head.next;
            return dummy.next;
        }
        dummy.next=head;
        ListNode pre = head;
        head=head.next;

        while(head!=null){
            if(head.val==val){
                pre.next = head.next;
                head.next=null;
                return dummy.next;
            }else{
                pre=head;
                head=head.next;
            }
        }
        return dummy.next;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
