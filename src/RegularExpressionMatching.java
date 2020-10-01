//LeetCode 10
/**
     Induction rule
     1, If p.charAt(j) == s.charAt(i) :  dp[i+1][j+1] = dp[i][j];
     2, If p.charAt(j) == '.' : dp[i+1][j+1] = dp[i][j];
     3, If p.charAt(j) == '*':
     two sub conditions:
     1   if p.charAt(j-1) != s.charAt(i) : dp[i+1][j+1] = dp[i+1][j]  //in this case, a* only counts as empty
     2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
         dp[i+1][j+1] = dp[i+1][j-1]   // in this case, a* counts as empty
      or dp[i+1][j+1] = dp[i][j+1]    //in this case, a* counts as one or multiple

     Time O(m*n)
     Space O(m*n)
 **/

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        //dp[i][j] means if it is a match between first i element in s and first j element in p
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        for(int i=0;i<s.length();i++){
            for(int j=0; j<p.length();j++){
                char curS = s.charAt(i);
                char curP = p.charAt(j);
                if(curS==curP||curP=='.'){
                    dp[i+1][j+1]=dp[i][j];
                }else if(curP=='*'){
                    char preP = p.charAt(j-1);
                    if(preP!=curS && preP!='.'){
                        dp[i+1][j+1]=dp[i+1][j-1];
                    } else{
                        dp[i+1][j+1] = (dp[i+1][j-1]|| dp[i][j+1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];

    }
}
