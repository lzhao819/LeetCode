// Given a binary tree in which each node contains an integer number. Find the maximum possible sum from any node to any node (the start node and the end node can be the same). 

// Assumptions

// ​The root of the given binary tree is not null
// Examples

//    -1

//   /    \

// 2      11

//      /    \

//     6    -14

// one example of paths could be -14 -> 11 -> -1 -> 2

// another example could be the node 11 itself

// The maximum path sum in the above binary tree is 6 + 11 + (-1) + 2 = 18

// How is the binary tree represented?

// We use the level order traversal sequence with a special symbol "#" denoting the null node.

// For Example:

// The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

//     1

//   /   \

//  2     3

//       /

//     4

//Space O(height)
//Time O(n)
public int MaximumPathSumBinaryTreeII(TreeNode root) {
    int[] globalMax = new int[]{Integer.MIN_VALUE};
    getSum(root, globalMax);
    return globalMax[0];
  }
  private int getSum(TreeNode root, int[] globalSum){
    if(root==null){
      return 0;
    }
    int l = getSum(root.left,globalSum);
    int r = getSum(root.right, globalSum);
    l = l>0? l :0;
    r = r>0? r :0;
    globalSum[0] = Math.max(l+r+root.key, globalSum[0]);
   
    return Math.max(l, r) + root.key; 
}