//Time O(n*m)
//Space O(n*m)-->可以在原数组修改使得变为 O（1）
public class MaxValueGift {
    //f(i,j) 等于 f(i,j-1) 和 f(i-1,j)中的较大值加上当前单元格礼物价值 grid(i,j)
    public int maxValue(int[][] grid) {
        if(grid==null||grid.length==0||grid[0]==null) return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i=1;i<grid.length;i++){
            dp[i][0] =  grid[i][0]+dp[i-1][0];
        }
        for(int j=1;j<grid[0].length;j++){
            dp[0][j] =  grid[0][j]+dp[0][j-1];
        }
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                dp[i][j]=grid[i][j]+Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
