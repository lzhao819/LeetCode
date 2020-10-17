package minimumSizeSubarraySum;

//209. Minimum Size Subarray Sum
/*
    Two pointer
    Time O(n)
    Space O(1)
 */
public class Solution {
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums==null || nums.length<1) return 0;

        int min_size = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;
        for(int end=0; end<nums.length; end++){
            sum+=nums[end];

            while(sum>=s){
                min_size = Math.min(min_size, end-start+1);
                sum-=nums[start++];
            }
        }

        return min_size == Integer.MAX_VALUE? 0 : min_size ;
    }

    public static void main(String[] args){
        int s=7;
        int[] nums = {2,3,1,2,4,3};
        int output = minSubArrayLen(s,nums);
        System.out.println(output);
    }
}
