//LeetCode 343. Integer Break
//力扣 剑指 剪绳子II

//public class IntegerBreak {
//}
/**
 * Method1 左大段 + 右小段
 */
class DPSolution{
    public int integerBreak(int n) {
        //dp[i] means the max product i can get
        int[] dp = new int[n+1];
        dp[0] =0;
        dp[1] =0;
        for(int i=2;i<=n;i++){
            //pick right most partition
            for(int j=1;j<i;j++){
                //for the left partition, we can choose not cut it or cut it
                //so the max number we can get is either j or dp[j]
                dp[i] = Math.max(dp[i], Math.max(j, dp[j])*(i-j));
            }
        }
        return dp[n];
    }
}

/**
 * Greddy for large input
 * 这个题和剪绳子I一样的描述，就是数据范围变大了。剪绳子可以用动态规划或者贪心做，这道题对于使用DP难度就增大了一些.
 * 因为数据范围变得比较大时，long已经不足以去存储中间结果的状态，但是由于DP做法是枚举各种剪的情况然后取最大值，因此只能通过使用BigInteger的方法去做.
 * 贪心思路：
 *    1会包含吗？ 不会，因为1 * (k - 1) < k, 只要把1和任何一个其他的片段组合在一起就有个更大的值
      2可以
      3可以
      4可以吗？ 它拆成两个2的效果和本身一样，因此也不考虑
      5以上可以吗？ 不可以，这些绳子必须拆，因为总有一种拆法比不拆更优，比如拆成 k / 2 和 k - k / 2
      综上, 最后的结果只包含2和3(当然当总长度为2和3时单独处理), 那么很显然n >= 5时， 3*(n - 3) >= 2 * (n - 2) ，因此我们优先拆成3，最后剩余的拆成2。最后的结果一定是由若干个3和1或2个2组成.
*/
class GreedySolution {
    public int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int mod = (int) 10e9 + 7;
        long result = 1;
        while (n > 4) {
            result *= 3;
            result %= mod;
            n -= 3;
        }
        result *= n;
        result %= mod;
        return (int) result;
    }
}

