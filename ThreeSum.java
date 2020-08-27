//LeetCode 15. 3 sum
//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//Time O(n^2)
//Space O(1)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>(); 
        //Assume array is not null && array.length >=3
        if(nums==null||nums.length<=2) return result;
        Arrays.sort(nums);
        //we want ot find i<j<k 
        //such that array[i]+array[j]+array[k]==target
        for(int i=0;i<nums.length-2;i++){
            //ignore duplicate i
            if(i>0&& nums[i]==nums[i-1]) continue;
            int left=i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    //ignore all duplication of j
                    while(left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                }else if(sum<0){
                    left++; 
                }else{
                    right--;
                }
            }
        }
        return result;  
       
    }
}