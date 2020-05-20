//No duplication
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length==0) return result;
        List<Integer> subSet =new ArrayList<Integer>();
        helper(result,subSet, 0, nums);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> subSet, int index,int[] nums){
        // ternimation conditon
        //when all the element are decided selected or not
        if(index==nums.length){
            //if use " list.add(subSet)“ instead of "list.add(new ArrayList<>(subSet))", will got a list of empty lists as the result 
            //Since in every recursion, we are using the same varibale named "list", 
            //if we don't clone it. the list you have if th final result list, which is a empty list(since we have a remove clause). Rather than a bunch of different lists.
            result.add(new ArrayList<>(subSet));
            return;
        }
        //case 1: not seleted
        helper(result,subSet, index+1, nums);
        //case2: select the element
        subSet.add(nums[index]);
        helper(result,subSet, index+1, nums);
        //delete when backtracking the previous level
        subSet.remove(subSet.size()-1);     
    }
}

//with duplication
//just sort before dfs
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length==0) return result;
        List<Integer> subSet = new ArrayList<Integer>();
        Arrays.sort(nums);
        helper(result, subSet, 0, nums);
        return result; 
    }
    private void helper(List<List<Integer>> result,List<Integer> subSet, int index, int[] nums ){
        if(index==nums.length){
            result.add(new ArrayList<>(subSet));
            return;
        }
        //case1: select
        subSet.add(nums[index]);
        helper(result, subSet, index+1, nums);
        subSet.remove(subSet.size()-1);
        //skip dup case
        while(index<nums.length-1 && nums[index]==nums[index+1]){
            index++;   
        }
        //case2:non select
        helper(result, subSet, index+1, nums);
    }
}

