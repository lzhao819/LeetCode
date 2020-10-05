import java.util.ArrayDeque;
import java.util.Queue;

class DFSInvertBinaryTree {
    /**
     * Time O(N) ： 其中 N 为二叉树的节点数量，建立二叉树镜像需要遍历树的所有节点，占用 O(N) 时间
     * Space O(N) ： 最差情况下（当二叉树退化为链表），递归时系统需使用 O(N) 大小的栈空间
     * 对于大的数据还是选择BFS好
     */
    public TreeNode invertTree(TreeNode root) {
        //recursive DFS
        if (root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }
}

class BFSInvertBinaryTree {
    /**
     * Time O(N) ： 其中 N 为二叉树的节点数量，建立二叉树镜像需要遍历树的所有节点，占用 O(N) 时间
     * Space O(N) ： 最差情况下（满二叉树时），栈 stack 最多同时存储 N/2 个节点
     */
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        return root;
    }
}
