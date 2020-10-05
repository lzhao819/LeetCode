/** 剑指26 Time O(M*N) 先序遍历树 A 占用 O(M) ，每次调用 helper(A, B) 判断占用 O(N) 。
 *  Space O(M) 当树 A 和树 B 都退化为链表时，递归调用深度最大。当 M<=N 时，遍历树 A 与递归判断的总递归深度为 M ；
 *                                                     当 M>N 时，最差情况为遍历至树 A 叶子节点，此时总递归深度为 M。
 */
public class IsSubStructureTree {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //corner case
        if(A==null||B==null) return false;
        /**以下三者满足一个即可返回true;
         * 1 把A和B传入isSubtree进行判断;
         * 2 验证B是不是A的左子树
         * 3 验证B是不是A的右子树；
         */
        return helper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean helper(TreeNode A, TreeNode B){
        //对传入的两个节点进行比较比较。开始遍历A的节点，然后传入到helper中，直到验证出B是A的子结构。
        if(B == null) return true; //说明B遍历结束
        if(A == null) return false; //说明A遍历结束而B没结束
        return A.val==B.val && helper(A.left, B.left) && helper(A.right, B.right);
    }
}
