//236 Lowest Common Ancestor of a Binary Tree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
      //return null: if there is no p or q in subtree
      //not null: 
      //1) if there is only one of the p/q node in the subtree, return p/q node itself
      //2) if both in subtree, return LCA 
      //   a) p is q's ancestor, return p
      //   b) q is p's ancestor, return q
      //   c) otherwise, return the lowest node with p and q in the two different subtrees
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //if root is p/q, we can ignore the later recursion
        if (root==null || root==p || root == q) return root;
        TreeNode ll = lowestCommonAncestor(root.left, p, q);
        TreeNode lr = lowestCommonAncestor(root.right, p, q);
        if(ll!=null && lr!=null){
          return root;
        }
        return ll==null? lr : ll;
    }
}