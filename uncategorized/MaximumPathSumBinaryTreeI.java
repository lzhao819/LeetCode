//Given a binary tree in which each node contains an integer number. Find the maximum possible subpath sum(both the starting and ending node of the subpath should be on the same path from root to one of the leaf nodes, and the subpath is allowed to contain only one node).
//any node to any node

//Time O(n) each node is O(1)
//Space O(height)
public class MaximumPathSumBinaryTreeI {
    public int maxPathSum(TreeNode root){
        int[] globalMax = new int[]{Integer.MIN_VALUE};
        getSum(globalMax, root);
        return globalMax[0]; 
    }
    //to parent: max of l/r + self
    //update global max
    private int getSum(int[] globalMax, TreeNode root){
        if(root==null){
            return 0;
        }
        int lSum = getSum(globalMax, root.left);
        int rSum = getSum(globalMax, root.right);
        //remember to check the cases when child is null
        if(root.left!=null && root.right!=null){
            globalMax[0] = Math.max(lSum+rSum +root.key,globalMax[0]);
            return Math.max(lSum, rSum) + root.key;
        }else if(root.left!=null){
            return lSum + root.key;
        }else{
            return rSum + root.key;
        }
    }
}  