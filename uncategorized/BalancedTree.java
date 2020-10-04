//Balanced Binary Tree
//a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
/**
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
//In Time O(n)
//Space O(height) 
class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root)!=-1;
    }
    
    private int getHeight(TreeNode root){
         /*If difference between heights of left and right subtrees 
            is more than 2 then this node is not balanced*/  
        if(root==null){
            return 0;
        }
        int lheight=getHeight(root.left);
        if(lheight!=-1){
            int rheight=getHeight(root.right);
            if(rheight!=-1){
                return Math.abs(lheight-rheight)<=1 ? 1+Math.max(lheight,rheight) : -1;
            }
        }
        return -1;  
    }  
};