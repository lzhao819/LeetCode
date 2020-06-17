//Practise7 BST
//search in BST
//iterative
//time O(height)
//space O(1)
public TreeNode search(TreeNode root, int value){
	if(root==null) return root;
	while(root!=null){
		if(root.key==value){
			return root;
		}else if(root.key<value){
			root=root.right;
		}else{
			root=root.left
		}
	}
	return null;
}

//recursive
//Time O(height)
//Space O(height)
public TreeNode search(TreeNode root, int value){
 	if(root==null || root.key==value) return root;
 	return root.key<value? search(root.right, key):search(root.left, key);
}

//insert in BST
//Iterative(往下看一眼)
public TreeNode insert(TreeNode root, int value){
	TreeNode newNode = new TreeNode(value);
	if(root==null){
		return newNode;
	}
	TreeNode cur=root;
	while(cur.key!=target){
		if(cur.key>target){
			if(cur.left!=null){
				cur=cur.left;
			}else{
				cur.left=newNode;
				break;
			}
		}else{
			if(cur.right!=null){
				cur=cur.right;
			}else{
				cur.right=newNode;
				break;
			}
		}
	}
	return root;
}

//Iterative(记录pre)
public TreeNode insert(TreeNode root, int value){
	if(root==null) return new TreeNode(value);
	TreeNode returnRoot = root;
	TreeNode pre = null;
	while(root!=null){
		pre=root;
		if(root.key<target){
			root=root.right;
		}else if(root.key>target){
			root=root.left;
		}else{
			return returnRoot;
		}
	}
	if(pre.key<target){
		pre.right=new TreeNode(target);
	}else if(pre.key>target){
		pre.left=new TreeNode(target);
	}
	return returnRoot;
}

//Recursive
public TreeNode insert(TreeNode root, int value){
	TreeNode newNode = new TreeNode(value);
	if(root==null) return newNode;
	if(root.key>value){
		root.left=insert(root.left, value);
	}else{
		root.right=insert(root.right, value);
	}
	return root;
}

//recursive(remove redundant operation) tail recursion
public TreeNode insert(TreeNode root, int value){
	if(root==null) return new TreeNode(value);
	helper(root, target);
	return root;
}
private void helper(TreeNode root, int value){
	if(target==root.value){
		return;
	}else if(target<root.value){
		if(root.left==null){
			root.left= new TreeNode(value);
		}else{
			helper(root.left, value);
		}	
	}else{
		//target>root.value
		if(root.right==null){
			root.right = new TreeNode(value);
		}else{
			helper(root.right, value);
		}
	}
}
