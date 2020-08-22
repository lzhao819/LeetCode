// Given a binary tree in which each node contains an integer number. Determine if there exists a path (the path can only be from one node to itself or to any of its descendants), the sum of the numbers on the path is the given target number.

// Examples

//     5

//   /    \

// 2      11

//      /    \

//     6     14

//   /

//  3

// If target = 17, There exists a path 11 + 6, the sum of the path is target.

// If target = 20, There exists a path 11 + 6 + 3, the sum of the path is target.

// If target = 10, There does not exist any paths sum of which is target.

// If target = 11, There exists a path only containing the node 11.

// How is the binary tree represented?

// We use the level order traversal sequence with a special symbol "#" denoting the null node.

// For Example:

// The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

//     1

//   /   \

//  2     3

//       /

//     4

 //time O(n)
 //space O(height)
public class BinaryTreePathSumToTargetIII {
    public boolean exist(TreeNode root, int target){
        if(root==null){
            return false;
        }
        Set<Integer> prefixSum = new HashSet<>();
        prefixSum.add(0);
        return helper(root, prefixSum, 0, target);
    }

    private boolean helper(TreeNode root, Set<Integer> prefixSum, int curSum, int target){
        curSum += root.key;
        boolean needRemove = prefixSum.add(curSum);
        if(prefixSum.contains(curSum - target)){
        return true;
        }
        if(root.left!=null && helper(root.left, prefixSum, curSum, target)){
        return true;
        }
        if(root.right!=null && helper(root.right, prefixSum, curSum, target)){
        return true;
        }
        if(needRemove) prefixSum.remove(curSum);
        return false;
    }
}

//对于need rermove 的解释
//因为prevSum在直上直下的路径上可能会重复出现，举例如下

//   3
//     \
//       -1
//         \
//            1
// 第一个数字prevSum = 3, 前三个数字的prevSum也=3，set（prefixSums）中的3不是leaf node加到set里的，如果在leaf node就把3从set里移除就不对了