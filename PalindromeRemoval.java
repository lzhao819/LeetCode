//LeetCode 1246. Palindrome Removal
// Given an integer array arr, in one move you can select a palindromic subarray arr[i], arr[i+1], ..., arr[j] where i <= j, and remove that subarray from the given array. Note that after removing a subarray, the elements on the left and on the right of that subarray move to fill the gap left by the removal.

// Return the minimum number of moves needed to remove all numbers from the array.

//Time O(n^3)
//Space O(n^2)
class Solution {
    public int minimumMoves(int[] arr) {
         /*
        dp[i][j] - min moves from arr[i:j]
        
		Init:
        dp[x][x] = 1
        dp[x][x+1] = 2 if arr[x] != arr[x+1] else 1
        
        transfer function consider dp[i][j]:
        
        1) if arr[i] == arr[j], it means we just need to focus on [i+1:j-1]
        finally when there is only one palindrome left in arr[i+1:j-1], 
        remove it together with arr[i], arr[j].
        that is to say, dp[i+1][j-1] is a candidate. 
        
        2) if arr[i] != arr[j], it means either one of them need to be removed
        for two different times. Two conditions apply:
        
        2.1) either one of them has to be removed as a single element
        min(dp[i+1][j], dp[i][j-1]) + 1 is another candidate
        
        2.2) both of them are part of longer palindrome on the left and right side
        e.g [2,3,2,7,4,5,4]
        in this case, need to try all the possible positions in the middle
        min { dp[i][k] + dp[k+1][j] } for k in [i+1, j-1] is third candidate
        
        ATTENTION !!! have to consider 1) 2.1) and 2.2) three candidates together,
		because even when arr[i] == arr[j] they are not necessarily removed in the same move,
		they can also be removed in left part and right part, respectively.
		
		return dp[0][n-1].
        */
        
        int n = arr.length;
        int[][] dp = new int[n][n];
        //initial array
        for (int[] d : dp) Arrays.fill(d, 0);
        
        //iteration from bottom up
        for(int i=n-1;i>=0;i--){
            for(int j=i; j<n; j++){
                if(i==j){
                    dp[i][j] = 1;
                }else if(i+1==j){
                    dp[i][j] = arr[i]==arr[j] ? 1:2;
                }else{
                    int cand1=n, cand2 = n;
                    if(arr[i]==arr[j]){
                        cand1=dp[i+1][j-1];
                    }
                    for(int k=i;k<j;k++){
                        cand2 = Math.min(cand2, dp[i][k]+dp[k+1][j]);
                    }
                    dp[i][j] = Math.min(cand1,cand2);
                }  
            }
        }
        return dp[0][n-1];  
    }
}