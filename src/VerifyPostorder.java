import java.util.ArrayDeque;
import java.util.Deque;

/**
 Time O(n^2)
 Space O(n),最多n层recursion
 */
class VerifyPostorderI {
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length-1);
    }
    private boolean helper(int[] postorder, int left, int right){
        //划分左右子树，再分别判断左右子树是否为BST
        if(left>=right) return true;
        int pointer = left;
        while(postorder[pointer]<postorder[right]){
            pointer++;
        }
        int mid = pointer;
        while(postorder[pointer]>postorder[right]){
            pointer++;
        }
        return pointer==right && helper(postorder, left, mid-1) && helper(postorder, mid, right-1);
    }
}

/**
 * 单调栈方法
   翻转先序遍历root->right->left的，基于这样的性质和遍历方式，我们知道越往右越大，这样，就可以构造一个单调递增的栈，来记录遍历的元素
   单调栈帮我们记录了这些节点，只要栈顶元素还比当前节点大，就表示还是右子树，要移除，因为我们要找到这个左孩子节点直接连接的父节点，也就是找到这个子树的根，只要栈顶元素还大于当前节点，就要一直弹出，直到栈顶元素小于节点，或者栈为空。栈顶的上一个元素就是子树节点的根。
   Time O(n)
   Space O(n),最多n层recursion
 */
class VerifyPostorderII {
    public boolean verifyPostorder(int[] postorder) {
        Deque<Integer> stack = new ArrayDeque<>();
        //表示上一个根节点的元素，这里可以把postorder的最后一个元素root看成无穷大节点的左孩子
        int root = Integer.MAX_VALUE;
        for(int i=postorder.length-1;i>=0;i--){
            // 左子树元素必须要小于递增栈被peek访问的元素，否则就不是二叉搜索树
            if(postorder[i]>root){
                return false;
            }
            while(!stack.isEmpty() && stack.peek()>postorder[i]){
                // 数组元素小于单调栈的元素了，表示往左子树走了，记录下上个根节点
                // 找到这个左子树对应的根节点，之前右子树全部弹出，不再记录，因为不可能在往根节点的右子树走了
                root=stack.pop();
            }
            // 这个新元素入栈
            stack.push(postorder[i]);
        }
        return true;
    }
}
