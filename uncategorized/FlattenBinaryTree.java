// Given a binary tree, flatten it to a linked list in-place.

// For example, given the following tree:

//     1
//    / \
//   2   5
//  / \   \
// 3   4   6
// The flattened tree should look like:

// 1
//  \
//   2
//    \
//     3
//      \
//       4
//        \
//         5
//          \
//           6

//time O(n)
//space O(1)
public class FlattenBinaryTree {
    public void flatten(TreeNode root){
        TreeNode[] prev = new TreeNode[1];
            helper(root, prev);
            return;   
    }
    private void helper(TreeNode root, TreeNode[] prev){
        //post order from right to lefft
        //keep a prev node 
        if(root==null) return;
        helper(root.right, prev);
        helper(root.left, prev);
        root.right = prev[0];
        root.left = null;
        prev[0] = root;
    }
}