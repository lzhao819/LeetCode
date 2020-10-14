import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指32
 * return int[] array
 * 注意返回时数据的处理
 *
 */
class BinaryTreeLevelOrderTraversalI {
    public int[] levelOrder(TreeNode root) {
        if(root==null) return new int[]{};
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            result.add(node.val);
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        int[] arr = new int[result.size()];
        for(int i=0;i<arr.length;i++){
            arr[i] = result.get(i);
        }
        return arr;
    }
}
/**
 * LeetCode 102 107
 * return list of list
 * 关键点在于用size控制层数
 */
class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> curLayer = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                curLayer.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            result.add(curLayer);//for bottom up, question107, just use list.add(0,curLayer);
        }
        return result;
    }
}

/**
 * 剑指32
 * 之字形打印
 * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * 关键在于：queue.size()可知道当前层有几个node， result.size()可以知道现在是第几层
 */
class BinaryTreeLevelOrderTraversalIII {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> curLayer = new ArrayList<>();
            int size = queue.size();
            for(int i=0; i<size;i++){
                TreeNode node = queue.poll();
                if((result.size()&1)==0){
                    //even
                    curLayer.add(node.val);
                }else{
                    //odd
                    curLayer.add(0,node.val);
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            result.add(curLayer);
        }
        return result;
    }
}
