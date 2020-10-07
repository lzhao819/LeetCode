import java.util.*;

//47 Permutations II
//This is int array version, 剑指 38 is string version
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null) return result;
        Arrays.sort(nums);
        helper(nums, 0, result);
        return result;
    }

    private void helper(int[] nums, int index, List<List<Integer>> result){
        if(index == nums.length-1){
            List<Integer> list= new ArrayList<>();
            for(int i: nums){
                list.add(i);
            }
            result.add(list);
            return;
        }
        Set<Integer> used = new HashSet<>();
        for(int i = index;i<nums.length; i++){
            //used.add(string[i]) will return false if string[i] is already exist
            if(used.add(nums[i])){
                swap(nums, i, index);
                //go for next level
                helper(nums, index+1, result);
                //do the clear opration while backtracking
                swap(nums, i, index);
            }
        }
    }//

    private void swap(int[] nums, int l, int r){
        int tmp = nums[l];
        nums[l]=nums[r];
        nums[r]=tmp;
    }
}
