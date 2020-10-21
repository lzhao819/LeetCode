import java.util.ArrayDeque;
import java.util.Deque;

class KthLargestBSTRecur {
    //时间复杂度 O(N) ： 当树退化为链表时（全部为右子节点），无论 k 的值大小，递归深度都为 N 。
    //空间复杂度 O(N) ： 当树退化为链表时（全部为右子节点），系统使用 O(N) 大小的栈空间。

    public int kthLargest(TreeNode root, int k) {
        if(root==null) return -1;
        int[] para = {k,0};//para[0] count, para[1] result
        helper(root, para);
        return para[1];
    }
    private void helper(TreeNode root, int[] para){
        if(root.right!=null){
            helper(root.right, para);
        }
        para[0]--;
        if(para[0]==0){
            para[1] = root.val;
            return;
        }
        if(root.left!=null){
            helper(root.left, para);
        }
    }
}
class KthLargestBSTIter{
    public int kthLargest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                stack.offerFirst(cur);
                cur=cur.right;
            }else{
                cur = stack.pollFirst();
                k--;
                if(k==0){
                    return cur.val;
                }
                cur = cur.left;
            }
        }
        return -1;
    }
}
