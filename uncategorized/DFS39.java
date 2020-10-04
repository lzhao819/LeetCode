class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result= new ArrayList<List<Integer>>();
        List<Integer> choice = new ArrayList<>();
        helper(candidates, target, 0, choice, result);
        return result;  
    }
    
    private void helper(int[] nums, int target, int index, List<Integer> choice, List<List<Integer>> result){
        //termination condition
        if(target==0){
            result.add(new ArrayList<Integer>(choice));
            return;
        }else if(target>0){
            for(int i=index;i<nums.length && target>=nums[i];i++){
                choice.add(nums[i]);
                helper(nums, target-nums[i], i, choice, result);
                choice.remove(choice.size()-1);
             }//for  
        }   
    }//helper
}

//compare with laioffer #73