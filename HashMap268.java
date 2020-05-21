class Solution {
    public int missingNumber(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        return (1+nums.length)*nums.length/2-sum;  
    }
}