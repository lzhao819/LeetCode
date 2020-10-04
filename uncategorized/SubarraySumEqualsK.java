//560. Subarray Sum Equals K
class Solution {
    public int subarraySum(int[] nums, int k) {
        //preix sum + HashMap
        //Time O(n)
        //space O(n)
        if(nums == null || nums.length<1) return 0;
        int count = 0;
        int sum = 0;
        //The hashmap is to record presum and frequency of the presum.
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        
        for(int i=0; i<nums.length;i++){
            sum+=nums[i];
            count+=preSum.getOrDefault(sum-k, 0);
            preSum.put(sum, preSum.getOrDefault(sum, 0)+1);
        
        }
        return count;
    }
    
     public int subarraySumII(int[] nums, int k) {
        //Time O(n^2)
        //space O(1)
        int count = 0;
        if(nums == null || nums.length<1) return count;
        for(int start=0; start<nums.length;start++){
            int sum = 0;
            for(int end=start;end<nums.length;end++){
                sum += nums[end];
                if(sum==k){
                    count++;
                }
            }   
        }
        return count;
    }
}