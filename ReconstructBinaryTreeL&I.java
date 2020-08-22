// Given the levelorder and inorder traversal sequence of a binary tree, reconstruct the original tree.

// Assumptions

// The given sequences are not null and they have the same length
// There are no duplicate keys in the binary tree
// Examples

// levelorder traversal = {5, 3, 8, 1, 4, 11}

// inorder traversal = {1, 3, 4, 5, 8, 11}

// the corresponding binary tree is

//         5

//       /    \

//     3        8

//   /   \        \

// 1      4        11

// How is the binary tree represented?

// We use  level order traversal sequence with a special symbol "#" denoting the null node.

// For Example:

// The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

//     1

//   /   \

//  2     3

//       /

//     4

//bestcase time O(nlogn)
//bestcase space O(n)
//worstcase time O(n^2)
//worstcase space O(n^2)
//分析过程可以参考笔记 recursionIII

public class ReconstructBinaryTreeL&I {
  public TreeNode reconstruct(int[] inOrder, int[] levelOrder){
    Map<Integer, Integer> inMap = new HashMap<>();
    //<Key number, Value index in inOrder>
    for(int i=0;i<inOrder.length;i++){
      inMap.put(inOrder[i], i);
    }
    //add all level order to the list
    List<Integer> leList = new ArrayList<>();
    for(int num : levelOrder){
      leList.add(num);
    }
    return helper(inMap, leList);   
  }

  private TreeNode helper(Map<Integer, Integer> inMap,List<Integer> leList){
      if(leList.isEmpty()){
          return null;
      }
      //E remove(int index): 
      //This method removes the element at the specified index and return it. 
      TreeNode root = new TreeNode(leList.remove(0));
      List<Integer> left = new ArrayList<>();
      List<Integer> right = new ArrayList<>();
      for(int num: leList){
          if(inMap.get(num)<inMap.get(root.key)){
          left.add(num);
          }else{
          right.add(num);
          }
      } 
      root.left = helper(inMap, left);
      root.right = helper(inMap, right);
      return root;
  }
}