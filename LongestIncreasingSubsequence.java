// Given an unsorted array of integers, find the length of longest increasing subsequence.

// Example:

// Input: [10,9,2,5,3,7,101,18]
// Output: 4 
// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 

class Solution {
    //DP with binary search
    //Insight1: we only care about length, if there are two candidate, we only need to save the smaller one
    //so that we only need a array: lowest_ending[i] =j means j is the lowest ending of all increasing subsequences of length i
    //insight2: lowest_ending[i]<lowest_ending[i+1]
    //time O(nlogn)
    public int lengthOfLIS2(int[] nums) {
        if(nums==null||nums.length<1) return 0;
        int[] lowest_ending = new int[nums.length];
        int size = 0;
        for(int x:nums){
            //binary search in lowest_ending[] to find the smallest elemt larger than a[i]
            int left=0, right=size;
            while(left<right){
                int mid=left+(right-left)/2;
                if(lowest_ending[mid]<x){
                    left=mid+1;
                }else{
                    right=mid;
                }
            }
            //Each time we only do one of the two:
            //(1) if x is larger than all tails, append it, increase the size by 1
            //(2) if tails[i-1] < x <= tails[i], update tails[i]
            lowest_ending[left]=x;
            if(left==size) size++; 
        }
        return size; 
    }

    //Troditional DP method
    //time O(n^2)
    //space O(n)
    public int lengthOfLIS1(int[] nums) {
        if(nums==null||nums.length<1) return 0;
        int globalMax = 0;
        //M[i] represent the longest subarray until i(included)
        int[] M = new int[nums.length];
        M[0]=1;
        for(int i=0;i<nums.length;i++){
            int localmax=0;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    localmax = Math.max(localmax, M[j]); 
                } 
            }
            M[i] = localmax+1;
            globalMax = Math.max(globalMax, M[i]);
            
        }
        return globalMax;
    }
}