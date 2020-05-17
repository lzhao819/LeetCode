//reverse of the preorder
public class Solution {
  public List<Integer> postOrder(TreeNode root) {
     List<Integer> result = new ArrayList<Integer>();
     if(root==null) return result;
     Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
     stack.offerFirst(root);
     while(!stack.isEmpty()){
       TreeNode cur=stack.pollFirst();
       result.add(cur.key);
       if(cur.left!=null){
       stack.offerFirst(cur.left);
        }
       if(cur.right!=null){
       stack.offerFirst(cur.right);
        }
     }
     Collections.reverse(result);
     return result;
  }
}

//another method is to check the relaton ship between current node and previous node