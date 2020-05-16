class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //assume the input tree is balanced
        //base case
        if(p==null||q==null){
            return p==q;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);  
    }
}
