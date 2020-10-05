import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class RecursiveSolution {
    /** Time O(N)： 其中 N 为二叉树的节点数量，每次执行 helper() 可以判断一对节点是否对称，因此最多调用 N/2 次 helper() 方法
     *  Space O(N)： 最差情况下二叉树退化为链表，系统使用 O(N)大小的栈空间。
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}

class InterativeSolution {
    /**
     * 把左右两个子树要比较的元素顺序入队，然后成对成对的取出来进行比较
     * Time：O(n)，因为我们遍历整个输入树一次，所以总的运行时间为O(n)，其中n是树中结点的总数。
     * Space O(n)：搜索队列需要额外的空间。在最糟糕情况下，我们不得不向队列中插入O(n)个结点。因此，空间复杂度为O(n)
     */
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        //这道题不能用ArrayDeque ，因为要存null节点，会报NPE错
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);// 将左子树头结点加入队列
        queue.offer(root.right);// 将右子树头结点加入队列

        while(!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            // 左右都为空，继续
            if(left==null && right==null) continue;
            // 左右一个节点不为空，或者都不为空但数值不相同，返回false
            if(left==null || right==null || left.val!=right.val) return false;
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }
}


