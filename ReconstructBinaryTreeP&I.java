// Given preorder and inorder traversal of a tree, construct the binary tree.

// Note:
// You may assume that duplicates do not exist in the tree.

// For example, given

// preorder = [3,9,20,15,7]
// inorder = [9,3,15,20,7]
// Return the following binary tree:

//     3
//    / \
//   9  20
//     /  \
//    15   7

// we have 2 arrays, PRE and IN.
// Preorder traversing implies that PRE[0] is the root node.
// Then we can find this PRE[0] in IN, say it's IN[5].
// Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
// Recursively doing this on subarrays, we can build a tree out of it :)
//Time O(n)
//Space O(n)
public class ReconstructBinaryTreeP&I {
  public TreeNode buildTree(int[] preOrder, int[] inOrder){
    //using inorder to determine the size of l/r subtree
    Map<Integer, Integer> indexMap = new HashMap<>();
    for(int i=0;i<inOrder.length;i++){
      indexMap.put(inOrder[i],i);
    }
    return helper(preOrder, indexMap, 0, inOrder.length-1, 0, preOrder.length-1);
  }
  private TreeNode helper(int[] preOrder, Map<Integer, Integer> indexMap, int inLeft, int inRight, int preLeft, int preRight){
  if(inLeft>inRight){
      return null;
  }
  TreeNode root = new TreeNode(preOrder[preLeft]);
  int inRoot = indexMap.get(root.key);
  int numsLeft = inRoot - inLeft;
  int numsRight = inRight - inRoot;
  root.left = helper(preOrder, indexMap, inLeft, inRoot-1, preLeft+1, preLeft+numsLeft);
  root.right = helper(preOrder, indexMap, inRoot+1, inRight, preRight-numsRight+1, preRight);
  return root;
  }
}