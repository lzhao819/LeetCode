//Laicode DIY reverse a tree upside down
//recursion
public TreeNode reverTree(TreeNode root){
	if(root==null||root.left==null){
		return root;
	}
	TreeNode newRoot = reverseTree(root.left);
	root.left.lefft=root.right;
	root.left.right = root;
	root.left=null;
	root.right=null;
	return newRoot;
}