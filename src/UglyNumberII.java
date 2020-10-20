/**
 * LeetCode264
 * 丑数的递推性质: 丑数只包含因子 2, 3, 5，因此 “丑数 == 某较小丑数 × 某因子” （例如：10 = 5×2）
 * 设置3个索引a, b, c，分别记录前几个数已经被乘2， 乘3， 乘5了，比如a表示前(a-1)个数都已经乘过一次2了，下次应该乘2的是第a个数；b表示前(b-1)个数都已经乘过一次3了，下次应该乘3的是第b个数；c表示前(c-1)个数都已经乘过一次5了，下次应该乘5的是第c个数
 *
 * 对于某个状态下的丑数序列，我们知道此时第a个数还没有乘2， 第b个数还没有乘3，第c个数还没有乘5, 下一个丑数一定是从第a丑数乘2， 第b个数乘3， 第c个数乘5中获得，他们三者最小的那个就是下个丑数
 * Inspired by @不是秒针
 * Time O(n)
 * Space O(n)
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int dp[] = new int[n]; //储存丑数
        dp[0]=1;
        int a=0, b=0,c=0;//设置索引a, b, c，分别记录前几个数已乘2， 乘3， 乘5
        for(int i=1; i<n;i++){
            int n2 = dp[a]*2, n3 = dp[b]*3, n5 = dp[c]*5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i]==n2) a++;
            if(dp[i]==n3) b++;
            if(dp[i]==n5) c++;
        }
        return dp[n-1];
    }
}

