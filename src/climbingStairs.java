
public class climbingStairs {
    //Time O(n)
    //Space O(n)
    public int climbStairs(int n) {
        if(n<=1) return n;
        //dp[i] means how many ways to reach i
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        
        for(int i=3; i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }   
}
