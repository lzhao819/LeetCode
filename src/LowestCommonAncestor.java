/**
 * 时间复杂度 O(N) ： 其中 N 为二叉树节点数；每循环一轮排除一层，二叉搜索树的层数最小为 logN （满二叉树），最大为 N （退化为链表）。
 * 空间复杂度 O(1) ： 使用常数大小的额外空间
 */
class LowestCommonAncestorIter {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            //都在左
            if(root.val>p.val && root.val>q.val){
                root=root.left;
            }else if(root.val<p.val && root.val<q.val){
                root = root.right;
            }else{
                return root;
            }
        }
        return root;
    }
}

//O（N）
//O（N）
class LowestCommonAncestorRecur{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val>p.val&& root.val>q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val<p.val&& root.val<q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
