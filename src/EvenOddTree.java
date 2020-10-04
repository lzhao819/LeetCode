import java.util.ArrayDeque;
import java.util.Queue;
//力扣5532 https://leetcode-cn.com/problems/even-odd-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class EvenOddTree {
    class MyPair{
        TreeNode node;
        int index;
        MyPair(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }
    public boolean isEvenOddTree(TreeNode root) {
        Queue<MyPair> queue = new ArrayDeque<>();
        queue.add(new MyPair(root, 0));
        int pre = Integer.MIN_VALUE;
        int curindex=-1;
        while(!queue.isEmpty()){
            MyPair tmp = queue.poll();
            TreeNode tmpnode = tmp.node;
            int tmpindex = tmp.index;
            if(tmpnode==null) continue;
            //换层
            if(tmpindex!=curindex) {
                if(tmpindex%2==0){
                    pre=Integer.MIN_VALUE;
                }else{
                    pre=Integer.MAX_VALUE;
                }
                curindex=tmpindex;
            }
            if(curindex%2==0){
                //偶数层：奇数递增
                if(tmpnode.val%2==0 || tmpnode.val<=pre) return false;
            }else if(curindex%2!=0){
                //奇数层：偶数递减
                if(tmpnode.val%2!=0||tmpnode.val>=pre) return false;
            }
            pre = tmpnode.val;
            queue.add(new MyPair(tmpnode.left, tmpindex+1));
            queue.add(new MyPair(tmpnode.right, tmpindex+1));
        }
        return true;
    }
}
