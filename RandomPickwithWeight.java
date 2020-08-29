// Given an array of positive integers w. where w[i] describes the weight of ith index (0-indexed).

// We need to call the function pickIndex() which randomly returns an integer in the range [0, w.length - 1]. pickIndex() should return the integer proportional to its weight in the w array. For example, for w = [1, 3], the probability of picking index 0 is 1 / (1 + 3) = 0.25 (i.e 25%) while the probability of picking index 1 is 3 / (1 + 3) = 0.75 (i.e 75%).

// More formally, the probability of picking index i is w[i] / sum(w).

class Solution {
    private int totalSum;
    private int[] prefixSum;

    public Solution(int[] w) {
        //In the constructor, we should also keep the total sum of the input numbers
        //so that later we could use this total sum to scale up the random number
        this.prefixSum = new int[w.length];
        int prefixSum=0;
        for(int i=0;i<w.length;i++){
            prefixSum +=w[i];
            this.prefixSum[i] = prefixSum;
        }
        this.totalSum = prefixSum;
        
    }
    
    //similar as find the largest number smaller than target
    //time O(logn)
    public int pickIndex() {
        double target = this.totalSum * Math.random();
        int l=0;
        int r = this.prefixSum.length;
        while(l<r){
            int mid = l+(r-l)/2;
            if(target>this.prefixSum[mid]){
                l=mid+1;
            }else{
                r=mid;
            } 
        }
        return l;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */