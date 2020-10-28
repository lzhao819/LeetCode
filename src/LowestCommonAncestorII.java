/**
 当 left 和 right 同时为空 ：说明 root 的左 / 右子树中都不包含 p,q ，返回 null
 当 left 和 right 同时不为空 ：说明在 root两侧 ，返回 root；
 当 left 为空 ，right 不为空 ：p,q 都不在 root 的左子树中，直接返回 right 。具体可分为两种情况：
 p,q 其中一个在 root 的 右子树 中，此时 right 指向 p（假设为 p ）；
 p,q 两节点都在 root 的 右子树 中，此时的 right 指向 最近公共祖先节点 ；
 当 left 不为空 ， right 为空 ：与情况 3. 同理；

 */
public class LowestCommonAncestorII {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root ==q){
            return root;
        }
        //如果其中一个是
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left==null && right==null){
            return null;
        }else if(left==null){
            return right;
        }else if(right==null){
            return left;
        }
        return root;

    }
}
