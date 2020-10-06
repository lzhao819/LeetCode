import java.util.ArrayList;
import java.util.List;

/**
 * Time O(N^2)
 * Space O(n)
 */
class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<>();
        dfs(result, path, root, sum);
        return result;
    }
    private void dfs(List<List<Integer>> result, List<Integer> path, TreeNode node, int remainingSum){
        if(node==null) return;
        path.add(node.val);
        // Check if the current node is a leaf and equals our remaining sum.
        //If it does, we add the path to result
        if(node.left==null && node.right==null && remainingSum == node.val){
            //because in back-tracking,the currentResult always changes, the result which refers to the currentResult will change either.
            //remember to add the copy to result
            result.add(new ArrayList<>(path));
        }else{
            // else, we will recurse on the left and the right children
            dfs(result, path, node.left, remainingSum-node.val);
            dfs(result, path, node.right, remainingSum-node.val);
        }
        path.remove(path.size()-1);
    }
}

