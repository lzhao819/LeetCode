package longestArithmeticSubsequence;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    //     The main idea is to maintain a map of differences seen at each index.

    //     Iteratively build the map for a new index i, by considering all elements to the left one-by-one.
    //     For each pair of indices (i,j) and difference d = A[i]-A[j] considered, we check if there was an existing chain at the index j with difference d already.

    //      If yes, we can then extend the existing chain length by 1.
    //      Else, if not, then we can start a new chain of length 2 with this new difference d and (A[j], A[i]) as its elements.
    //      At the end, we can then return the maximum chain length that we have seen so far.

    // Time  O(n^2)
    // Space O(n^2)
    public int longestArithmeticSubsequence(int[] A) {
        int res = 0;
        Map<Integer, Integer>[] dp = new HashMap[A.length];
        for(int j=0; j<A.length; j++){
            dp[j] = new HashMap<>();
            for(int i=0; i<j; i++){
                int d = A[j]- A[i];
                dp[j].put(d, dp[i].getOrDefault(d,1) +1);
                res = Math.max(res, dp[j].get(d));
            }
        }
        return res;
    }
}
