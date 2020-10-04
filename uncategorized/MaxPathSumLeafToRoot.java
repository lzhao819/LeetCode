// Given a binary tree in which each node contains an integer number. Find the maximum possible path sum from a leaf to root.
//leave to root 
// Assumptions
// The root of given binary tree is not null.

// Examples
//          10
//        /      \
//     -2        7
//   /     \
// 8      -4
// The maximum path sum is 10 + 7 = 17.

//Time O(n)
//Space O(height)


public int MaxPathSumLeafToRoot(TreeNode root) {
  if(root ==null) return 0;
  if(root.left==null && root.right ==null){
    return root.key;
  }else if(root.left==null){
    return MaxPathSumLeafToRoot(root.right)+root.key;
  }else if(root.right==null){
    return MaxPathSumLeafToRoot(root.left)+root.key;
  }
  
  return root.key + Math.max(MaxPathSumLeafToRoot(root.right), MaxPathSumLeafToRoot(root.left));
}
