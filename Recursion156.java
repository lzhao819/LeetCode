//156 Binary Tree Upside Down 
//Laicode 178 Reverse Binary Tree Upside Down
// Given a binary tree where all the right nodes are leaf nodes, flip it upside down and turn it into a tree with left leaf nodes as the root.

// Examples

//         1

//       /    \

//     2        5

//   /   \

// 3      4

// is reversed to

//         3

//       /    \

//     2        4

//   /   \

// 1      5

// 113

/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  //Method1: recursion
  public TreeNode reverseI(TreeNode root) {
    if(root == null || root.left==null) return root;
    TreeNode newRoot = reverse(root.left);
    root.left.left = root;
    root.left.right = root.right;
    root.left=null;
    root.right=null;
    return newRoot;
  }
  //Method2: iteration
  public TreeNode reverseII(TreeNode root) {
    TreeNode pre = null;
    TreeNode preRight = null;
    while(root!=null){
      TreeNode next = root.left;
      TreeNode right = root.right;
      root.right = preRight;
      root.left = pre;
      preRight=right;
      pre=root;
      root=next;
    }
    return pre;
  }
}

