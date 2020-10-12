public class translateNum {
    //Time O(n)
    //Space O(n)
    public int translateNum(int num) {
        String s = Integer.toString(num);
        //dp[i+1] means ways to translate num [0,i]
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        //一位数--dp[i] = dp[i-1]
        //和前一位组成的两位数大于25 dp[i] = dp[i-1];
        //和前一位大于9小于等于25 dp[i] = dp[i-2]+dp[i-1];
        for(int i=1;i<s.length();i++){
            int index = i+1;
            int combi = (s.charAt(i)-'0')+(s.charAt(i-1)-'0')*10;
            if(combi>9 && combi<=25){
                dp[index]=dp[index-1]+dp[index-2];
            }else{
                dp[index]=dp[index-1];
            }
        }
        return dp[s.length()];
    }
}
