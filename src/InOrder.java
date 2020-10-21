//Iteration
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class InOrderI {
  class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int key) {
      this.key = key;
    }
  }
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

class InOrderII {
  class TreeNode {
    public int key;
    public InOrderI.TreeNode left;
    public InOrderI.TreeNode right;
    public TreeNode(int key) {
      this.key = key;
    }
  }
//  //另一个巧方法 Time O(n) Space O(height)
//  public void inOrder(TreeNode root) {
//    //1 initial check
//    if (root == null) {
//      return;
//    }
//    //2 we need a tack and a helper node
//    Deque<TreeNode> stack = new ArrayDeque<>();
//    TreeNode helper = root;
//    //3
//    while (helper != null || !stack.isEmpty()) {
//      if (helper != null) {
//        stack.offerFirst(helper);
//        helper = helper.left;
//      } else {
//        //top是左子树都被打印完的根
//        helper = stack.pollFirst();
//        System.out.println(helper.key);
//        helper = helper.right;
//      }
//    }
//  }
//}

}



