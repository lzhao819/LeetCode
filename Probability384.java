//384 Shuffle an Array
class Solution {
    private int[] nums;
    private int[] oris;

    public Solution(int[] nums) {
        this.nums= new int[nums.length];
        this.oris= new int[nums.length];
        for(int i =0; i<nums.length;i++){
            this.nums[i] = nums[i];
            this.oris[i] = nums[i];
        } 
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return oris;  
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i=nums.length;i>=1;i--){ 
            int j=(int)(Math.random()*i);
            swap(i-1, j);
        }
        return nums;
    }
    
    private void swap(int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */