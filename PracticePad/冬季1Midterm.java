//冬季1 Mid term
//check if is a bst
public boolean isBST(TreeNode root){
	if(root==null) return true;
	return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
}
private boolean helper(TreeNode root, int min, int max){
	if(root.value<=min || root.value>=max){
		return false;
	}
	return isBST(root.left, min, root.value) && isBST(root.right, root, max) ;
}

//all permutation of a string
public List<String> permutation(String s){
	if(s==null) return new ArrayList<String>();
	List<String> result = new ArrayList<String>();
	char[] array = s.toCharArray();
	DFS(array,0, result);
	return result;
}
private void DFS(char[] array, int offset, List<String>result){
	if(offset==array.length){
		result.add(new String(array));
		return;
	}
	Set<Character> set = new HashSet<>();
	for(int i =offset; i<array.length;i++){
		if(set.add(array[i])){
		swap(arraíy,offset,i);
		DFS(array, offset+1, result);
		swap(array,offset,i);
		}
	}	
}
private void swap(char[] array, int a, int b){
	char temp= array[a];
	array[a] = array[b];
	array[b] = temp;
	return;
}

//kth smallest sum in sorted array A and B
//Laicode27