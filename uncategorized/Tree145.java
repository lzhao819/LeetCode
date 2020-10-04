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

//another method is to check the relatonship between current node and previous node
public void postOrder(TreeNode root) {
  //Time O(n) Space O(height)
  //initial check
  if(root==null) return;
  //local variables
  Deque<TreeNode> stack = new LinkedList<>();
  TreeNode prev =null;
  stack.offerFirst(root);
  //3
  while(!stack.isEmpty()){
    TreeNode current = stack.peekFirst();
    //going down
    if(prev==null||current==prev.left||current==prev.right){
      if(current.left!=null){
        stack.offerFirst(current.left);
      }else if(current.right!=null){
        stack.offerFirst(current.right);
      }else{
        System.out.println(current.value);
        stack.pollFirst();
      }
    }else if(prev==cur.left){//from left subtree
      if(current.right!=null){
        stack.offerFirst(current.right);
      }else{
        System.out.println(current.value);
        stack.pollFirst();
      }
    }else{//from right subtree
      System.out.println(current.value);
      stack.pollFirst();
    }
    prev = current;
  }
}