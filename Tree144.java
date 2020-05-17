//Recursion

public class Solution {
  public List<Integer> preOrder(TreeNode root) {
    List<Integer> list= new ArrayList<Integer>();
    preOrder(root, list);
    return list;
  }
  private void preOrder(TreeNode root,List<Integer> list){
    if(root==null) return;
    list.add(root.key);
    preOrder(root.left,list);
    preOrder(root.right,list);
  }
}

//Iteration
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        if(root==null){
            return result;
        }
        Deque<TreeNode> stack= new ArrayDeque<TreeNode>();
        stack.offerFirst(root);
        while(!stack.isEmpty()){
            TreeNode cur= stack.pollFirst(); 
            if(cur.right!=null){
                stack.offerFirst(cur.right);
            }
            if(cur.left!=null){
                stack.offerFirst(cur.left);
            }
            result.add(cur.val);
        }
        return result;  
    }
}
