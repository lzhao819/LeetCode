class Solution {
	//solution1
    public int missingNumber(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum+=i;
        }
        return (1+nums.length)*nums.length/2-sum;  
    }

    //solution2 bit operation O(n)
    public int missingNumber(int[] nums) {
    	int n = array.length+1;
    	int xor = 0;
    	//xor 1 to n
    	for(int i=1; i<=n; i++){
    		xor ^= i;
    	}
    	//after this operation all the numbner from 1 to n are paired xor'ed 
    	//except for the missing number
    	//since x ^ x = 0, the remaining number is the result
    	for(int num : array){
    		xor^=num;
    	}
    	return xor;
    }
}