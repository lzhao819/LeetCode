// Given the postorder traversal sequence of a binary search tree, reconstruct the original tree.

// Assumptions
// The given sequence is not null
// There are no duplicate keys in the binary search tree
// Examples

// postorder traversal = {1, 4, 3, 11, 8, 5}

// the corresponding binary search tree is

//         5

//       /    \

//     3        8

//   /   \        \

// 1      4        11

// How is the binary tree represented?

// We use the pre order traversal sequence with a special symbol "#" denoting the null node.

// For Example:

// The sequence [1, 2, #, #, 3, 4, #, #, #] represents the following binary tree:

//     1

//   /   \

//  2     3

//       /

//     4

//time O(n)
//space O(n)
public class ReconstructBSTPost {
    public TreeNode reconstruct(int[] post){
    // last is the root, index[0] 记录当前root对应的index
    int[] index = new int[]{post.length-1};
    return helper(post, index, Integer.MIN_VALUE);
    }

    private TreeNode helper(int[] post, int[] index, int min){
        //since it is the the BST, the min is the root
        //we use the root to determine the boundry of l/r subtree
        if(index[0]<0 || post[index[0]]<=min){
            return null;
        }
        TreeNode root = new TreeNode(post[index[0]--]);
        root.right = helper(post, index, root.key);
        root.left = helper(post, index, min);
        return root;
    }
}