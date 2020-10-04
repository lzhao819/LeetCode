//Method I better, reduce redundence
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        helper(root, val);
        return root;
    }
    private void helper(TreeNode root, int value){
        if(value==root.val){
            return;
        }else if(value<root.val){
            if(root.left==null){
                root.left= new TreeNode(value);
            }else{
                helper(root.left, value);
            }   
        }else{
            //target>root.val
            if(root.right==null){
                root.right = new TreeNode(value);
            }else{
                helper(root.right, value);
            }
        }
    }
}

//Method 2
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

//Iterative method see practise7