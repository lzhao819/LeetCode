//Iteration
/**
 * public class TreeNode {
 *   public int key;
 *   public TreeNode left;
 *   public TreeNode right;
 *   public TreeNode(int key) {
 *     this.key = key;
 *   }
 * }
 */
public class Solution {
  public List<Integer> inOrder(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    Deque<TreeNode> stack=new ArrayDeque<TreeNode>();
    TreeNode cur=root;
    while(cur!=null||!stack.isEmpty()){
      if(cur!=null){
        stack.offerFirst(cur);
        cur=cur.left;
      }else{
        cur=stack.pollFirst();
        result.add(cur.key);
        cur=cur.right;
      }
    }
     return result;
  }
}

