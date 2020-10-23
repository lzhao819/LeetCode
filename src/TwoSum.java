// Given an array of integers, return indices of the two numbers such that they add up to a specific target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

//time O(n)
//Spcace O(n)

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSumMap {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if(nums==null || nums.length<2) return result;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            if(map.containsKey(nums[i])){
                result[0] = i;
                result[1] = map.get(nums[i]);
                return result;
            }
                map.put(target - nums[i], i);  
        }
        Arrays.sort(result);
        return result;
    }
}
class TwoSumPointer{
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int i=0, j=nums.length-1;
        while(i<j){
            int sum = nums[i]+nums[j];
            if(sum==target){
                return new int[]{nums[i], nums[j]};
            }else if(sum>target){
                j--;
            }else{
                i++;
            }
        }
        return new int[]{-1, -1};
    }
}