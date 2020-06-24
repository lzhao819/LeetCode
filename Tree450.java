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
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        
        if(root.val==key){
            //val==key, 4 cases
            //node doesn't have children; left is null; right is null;
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }else if (root.right.left==null){
                root.right.left= root.left;
                return root.right;
            }else{
                TreeNode newRoot=deleteSmallest(root.right);
                newRoot.left=root.left;
                newRoot.right=root.right;
                return newRoot;   
             }    
        }
        
        if(root.val<key){
            root.right= deleteNode(root.right,key);
        }else if(root.val>key){
            root.left= deleteNode(root.left,key);
        }
        return root;
    }
    
    //find and delete smallest node
    private TreeNode deleteSmallest(TreeNode node){
        while(node.left.left!=null){
            node=node.left;
        }
        TreeNode smallest=node.left;
        node.left=node.left.right;
        return smallest; 
    }
}

//Anna method
public TreeNode deleteNode(TreeNode root, int key){
    if(root==null) return null;
    //find target node
    if(root.val>key){
        root.left=deleteNode(root.left,key);
        return root;
    }else if(root.val<key){
        root.right = deleteNode(root.right,key);
        return root;
    }
    //guarantee root!=null && root.value==target
    if(root.left==null){
        return root.right;
    }else if(root.right==null){
        return root.left;
    }
    //guarantee root.left!=null && root.right!=null
    //4.1 
    if(root.right.left==null){
        root.right.left=root.left;
        return root.right;
    }
    //4.2
    //1 find and delete smallest nod in root.right
    TreeNode smallest = deleteSmallest(root.right);
    //2 connect the smallest node with root.left and root.right
    smallest.left=root.left;
    smallest.right=root.right;
    //3 return the smallest node
    return smallest;
}
private TreeNode deleteSmallest(TreeNode cur){
    TreeNode prev = cur;
    cur=cur.left;
    while(cur.left!=null){
        prev=cur;
        cur=cur.left;
    }
    //cur is the smallest one, and prev is its parent
    //invariance: cur(prev.left) doesn't has left child
    prev.left=cur.right;
    return cur;
}