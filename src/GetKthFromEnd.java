import java.util.ArrayList;
import java.util.List;

class GetKthFromEnd {
    // 指针 slow 、指针 fast ，双指针都指向头节点 head​ 。
    //构建双指针距离：fast 先向前走 k 步（结束后，双指针间相距 k 步）
    public ListNode getKthFromEnd(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        ListNode slow = head;
        ListNode fast = head;
        for(int i=0;i<k;i++){
            if(fast!=null){
                fast=fast.next;
            }else{
                return null;
            }
        }
        while(fast!=null){
            slow = slow.next;
            fast=fast.next;
        }
        return slow;
    }
}