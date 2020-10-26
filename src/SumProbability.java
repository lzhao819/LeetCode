class SumProbabilityOptimized{
/**
* 空间优化
 * 每个阶段的状态都只和它前一阶段的状态有关，因此我们不需要保存所有阶段。
 * 用一维数组来保存一个阶段的状态，然后对下一个阶段可能出现的点数 j 从大到小遍历，实现一个阶段到下一阶段的转换。
* */
    public double[] twoSum(int n) {
        int dp[] = new int[6*n+1];
        //第一次的情况，也是边界条件
        for(int i=1;i<=6;i++){
            dp[i] = 1;
        }
        for(int i=2;i<=n;i++){
            for(int j=i*6; j>=i;j--){
                dp[j]=0;
                for(int cur=1;cur<=6;cur++){
                    if(j-cur<i-1){
                        break;
                    }
                    dp[j] += dp[j-cur];
                }
            }
        }
        //n次的所有可能情况
        double all = Math.pow(6,n);
        double[] result = new double[6*n-n+1];
        for(int i=n;i<=6*n;i++){
            result[i-n] = (double)dp[i]/all;

        }
        return result;
    }
}

class SumProbabilityDummy {
    /**int dp[i][j]
    i 表示阶段，也就是投掷完了几枚骰子。
    j 表示投掷完这些骰子后，可能出现的点数。
    值就表示，该阶段各个点数出现的次数。
    第 n 枚骰子，它的点数可能为 1,2,3,...,6 ，因此投掷完 n 枚骰子后点数 j 出现的次数，可以由投掷完 n−1 枚骰子后，对应点数j−1,j−2,j−3,...,j−6 出现的次数之和转化过来。
    for (第n枚骰子的点数 i = 1; i <= 6; i ++) {dp[n][j] += dp[n-1][j - i]}
     */
    public double[] twoSum(int n) {
        //系数为0的不考虑，i为n说明有n个骰子，j为6*n表示所有可能的点数和有这么多种
        int dp[][] = new int[n+1][6*n+1];
        //第一次的情况，也是边界条件
        for(int i=1;i<=6;i++){
            dp[1][i] = 1;
        }
        //每多一个色子的情况
        for(int i=2;i<=n;i++){
            //这么多色子情况下的所有可能和
            for(int j=i; j<=6*i;j++){
                //为了找到能得到这种可能和，对于少一个色子时的所有可能情况，相加即是当前可能总和
                for(int cur=1;cur<=6&&cur<=j;cur++){
                    dp[i][j] += dp[i-1][j-cur];
                }
            }
        }
        //n次的所有可能情况
        double all = Math.pow(6,n);
        double[] result = new double[6*n-n+1];
        for(int i=n;i<=6*n;i++){
            result[i-n] = (double)dp[n][i]/all;

        }
        return result;
    }
}
