class ReconstructBSTPre {
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] index = new int[1];
        return helper(preorder, index,Integer.MAX_VALUE);     
    }
    private TreeNode helper(int[] pre, int[] index, int max){
        if(index[0]>=pre.length || pre[index[0]]>max){
            return null;
        }
        TreeNode root = new TreeNode(pre[index[0]++]);
        root.left = helper(pre, index, root.val);
        root.right = helper(pre, index, max);
        return root;
    }
}