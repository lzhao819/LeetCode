class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
         List<List<Integer>> list = new ArrayList<List<Integer>>();
         if(root==null){
           return list;
         }
         //save node to be expand in a queue
         Queue<TreeNode> queue = new LinkedList<TreeNode>();
         queue.offer(root);
         while(!queue.isEmpty()){
           //list to save curent layer keys
           List<Integer> curLayer = new ArrayList<Integer>();
           int size = queue.size();
           for(int i=0;i<size;i++){
             TreeNode cur = queue.poll();
             curLayer.add(cur.val);
             if(cur.left!=null){
               queue.offer(cur.left);
             }
             if(cur.right!=null){
               queue.offer(cur.right);
             }
           }
           list.add(curLayer);//for bottom up, question107, just use list.add(0,curLayer);
         }
         return list;
    }
}