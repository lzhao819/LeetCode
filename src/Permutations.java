import java.util.ArrayList;
import java.util.List;

//recommanded: SWAP method!!
class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length==0) return result;
        helper(nums, result, 0);
        return result; 
    }

    //choose the char to be at 'index'
    //all the already chosen position are(0,index-1)
    //all the candidate are in the subarray of (index, array.length-1)
    private void helper(int[] nums, List<List<Integer>> result, int index){
        //termination condition
        if(index==nums.length){
            //convert int array to integer list
            List<Integer> list = new ArrayList<>();
            for (int i : nums) {
                list.add(Integer.valueOf(i));
            }
            result.add(list);
            return;
        }
        //all the candidate are in the subarray of (index, array.length-1)
        for(int i=index;i<nums.length;i++){
            swap(nums, index, i); 
            helper(nums, result, index+1);
            swap(nums,index,i);
        }//for 
    }//helper
    
    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp; 
    }
}




//NOT recommanded: maintain the order of all permutations
class PermutationsSolution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> sub = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        helper(nums, result, sub, used);
        return result; 
    }
    private void helper(int[] nums, List<List<Integer>> result, List<Integer> sub, boolean[] used){
        //termination condition
        if(sub.size()==nums.length){
            result.add(new ArrayList<>(sub));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                sub.add(nums[i]);
                used[i]=true;
                helper(nums, result, sub, used);
                used[i]=false;
                sub.remove(sub.size()-1);
            }   
        }//for 
    }
}
