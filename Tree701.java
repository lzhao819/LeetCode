class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node=new TreeNode(val);
        if(root==null) return node;
        if(root.val>val){
            root.left=insertIntoBST(root.left,val);
        } else if(root.val<val){
            root.right= insertIntoBST(root.right,val);
        } 
        return root;   
    }
}