//Time O(N)
//Space O(N)

import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node!=null){
                sb.append(node.val + ",");
                queue.offer(node.left);
                queue.offer(node.right);
            }else{
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);
        int i=1;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(!vals[i].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(vals[i]));
                node.left = left;
                queue.offer(left);
            }
            i++;
            if(!vals[i].equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(vals[i]));
                node.right = right;
                queue.offer(right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
