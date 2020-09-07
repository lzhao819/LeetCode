//238. Product of Array Except Self
class Solution {
    public int[] productExceptSelfI(int[] nums) {
        //Time O(n) solution L[] and R[]
        //Space O(n)
        if(nums==null||nums.length<1) return nums;
        int[] L = new int[nums.length];
        int[] R = new int[nums.length];
        int[] result = new int[nums.length];
        L[0] = 1;
        for(int i=1; i<nums.length;i++){
            L[i] = nums[i-1]*L[i-1];
        }
        R[nums.length-1] = 1;
        for(int i=nums.length-2; i>=0;i--){
            R[i] = nums[i+1]*R[i+1];
        }
        for(int i=0; i<nums.length; i++){
            result[i] = R[i]*L[i]; 
        }
        return result;
    }
     public int[] productExceptSelf(int[] nums) {
        //Time O(n)
        //Space O(1) optimazed solution
        if(nums==null||nums.length<1) return nums;
        int[] result = new int[nums.length];
        result[0] = 1;
        for(int i=1; i<nums.length;i++){
            result[i] = nums[i-1]*result[i-1];
        }
        int R = 1;
        for(int i=nums.length-1; i>=0;i--){
            result[i] = result[i]*R;
            R = nums[i]*R;
        }
        return result;
    }
}