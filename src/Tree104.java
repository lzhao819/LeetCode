import java.util.ArrayDeque;
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
//后序遍历 / 深度优先
//Time O(n)
    //Space O(height) worseCase O(N)
class Tree104DFS {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
//层序遍历（BFS）
//O(N) O(N)
class Tree104BS {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        int count=0;
        if(root==null) return count;
        queue.offer(root);
        while(!queue.isEmpty()){
            int n=queue.size();
            count++;
            for(int i=0;i<n;i++){
                TreeNode tmp = queue.poll();
                if(tmp.left!=null){
                    queue.offer(tmp.left);
                }
                if(tmp.right!=null){
                    queue.offer(tmp.right);
                }
            }
        }
        return count;
    }
}