//LeetCode 53. Maximum Subarray
// Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
// Assumptions

// The given array is not null and has length of at least 1.
// Examples

// {2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5

// {-2, -1, -3}, the largest subarray sum is -1
//Time O(n)
//Spcace O(1)
class Solution {
  public int maxSubArray(int[] nums) {
      if(nums==null) return Integer.MIN_VALUE;
      int globalMax = nums[0];
      int lastMax=nums[0];
      for(int i=1;i<nums.length;i++){
          lastMax = Math.max(nums[i],lastMax+nums[i]);
          globalMax = Math.max(globalMax, lastMax);  
      }
      return globalMax;
  }
}