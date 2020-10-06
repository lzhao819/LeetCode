import java.util.ArrayDeque;
import java.util.Deque;

/**
 * DFS recursive method
 * Time O（N）
 * Space O(N)
 */
class ConvertBinarySearchTreetoSortedDoublyLinkedListI{
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        //inOrder
        if(root==null) return root;
        dfs(root);
        head.left=pre;//头尾互指
        pre.right=head;
        return head;
    }
    private void dfs(Node cur){
        if(cur==null){ return;}
        dfs(cur.left);
        if(pre!=null){
            pre.right=cur;
        }else{
            head=cur;
        }
        cur.left=pre;
        pre=cur;
        dfs(cur.right);
    }
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
/**
 * Iterative using stack for inorder traverse
 */
class ConvertBinarySearchTreetoSortedDoublyLinkedListII {
    public Node treeToDoublyList(Node root) {
        //inOrder
        Deque<Node> stack = new ArrayDeque<>();
        if(root==null) return root;
        Node dummy = new Node(0);
        Node pre = dummy;
        Node cur = root;
        while(!stack.isEmpty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                cur=stack.pop();
                cur.left=pre;
                pre.right=cur;
                pre=cur;
                cur = cur.right;
            }
        }
        dummy.right.left=pre;
        pre.right = dummy.right;
        return dummy.right;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}

