import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * LeetCode 47 Permutations II 是此题的数组版
 *
 * Time O(n!)
 * 时间复杂度和字符串排列的方案数成线性关系，方案数为 N * (N-1) * (N-2) … *2 * 1
 * Space O(n^2)
 * 全排列的递归深度为 N ，系统累计使用栈空间大小为 O(N) ；递归中辅助 Set 累计存储的字符数量最多为 N + (N-1) + ... + 2 + 1 = (N+1)N/2，即占用 O(N^2)的额外空间
 *
 */
class StringPermutation {
    public String[] permutation(String s) {
        if(s==null||s.length()==0) return new String[]{};
        char[] arr = s.toCharArray();
        List<String> result = new ArrayList<>();
        dfs(arr, result, 0);
        return result.toArray(new String[0]);
    }
    private void dfs(char[] arr, List<String> result, int index){
        //termination condition
        if(index==arr.length-1){
            result.add(new String(arr));
            return;
        }
        Set<Character> set = new HashSet<>();
        //all the candidate are in the subarray of (index, array.length-1)
        for(int i=index;i<arr.length;i++){
            if(set.add(arr[i])){
                swap(arr, index, i);
                dfs(arr, result, index+1);
                swap(arr, index, i);
            }else{
                continue;
            }
        }
    }
    private void swap(char[] arr, int a, int b){
        char tmp = arr[a];
        arr[a]=arr[b];
        arr[b]=tmp;
    }
}
