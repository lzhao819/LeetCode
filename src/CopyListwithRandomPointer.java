import java.util.HashMap;
import java.util.Map;
//https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/solution/lian-biao-de-shen-kao-bei-by-z1m/
public class CopyListwithRandomPointer {
    //Time O(n)
    //Space O(n)
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        //复制结点值
        while(cur!=null){
            map.put(cur, new Node(cur.val));//顺序遍历，存储老结点和新结点(先存储新创建的结点值)
            cur=cur.next;
        }
        cur=head;
        while(cur!=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
