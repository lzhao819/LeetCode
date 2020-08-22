//Given a binary tree in which each node contains an integer number. Find the maximum possible subpath sum(both the starting and ending node of the subpath should be on the same path from root to one of the leaf nodes, and the subpath is allowed to contain only one node).

public class MaximumPathSumBinaryTreeIII {
    public int maxPathSum(TreeNode root){
        int[] globalMax = new int[]{Integer.MIN_VALUE};
        helper(root,globalMax);
        return globalMax[0];
    }
    //globalMax[0] is the final value
    //return value of helper funtion is the max of sum of the current subtree in left and right
    private int helper(TreeNode root, int[] globalMax){
    if(root==null) return 0;
    int l = Math.max(0, helper(root.left, globalMax));
    int r = Math.max(0, helper(root.right, globalMax));
    globalMax[0] = Math.max(Math.max(l,r)+root.key, globalMax[0]);
    return Math.max(l, r) + root.key;
    } 
}