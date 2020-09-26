package distinctSubsequences;

//https://leetcode.com/problems/distinct-subsequences/discuss/37327/Easy-to-understand-DP-in-Java
//time O(m*n)
//Space O(m*n)
public class Solution {
    public int numDistinct(String s, String t) {
        if(s==null || t==null) return 0;
        //mem[i+1][j+1] means that S[0..j] contains T[0..i] that many times as distinct subsequences.
        //Therefor the result will be mem[T.length()][S.length()].
        int[][] mem = new int[t.length()+1][s.length()+1];
        // initialize the dp value when t is an empty string, number of subsequence of an empty string should be 1
        for(int i=0; i<=s.length();i++){
            mem[0][i]=1;
        }
        //first col is 0 by default in every other rows but the first.
        for(int i=0; i<t.length();i++){
            for(int j=0; j<s.length(); j++){
                if(t.charAt(i)==s.charAt(j)){
                    mem[i+1][j+1]=mem[i+1][j] + mem[i][j];
                }else{
                    mem[i+1][j+1]=mem[i+1][j];
                }
            }
        }
        return mem[t.length()][s.length()];
    }
}
