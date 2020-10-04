//Laicode 143. Minimum Cuts For Palindromes
// Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome. Determine the fewest cuts needed for a palindrome partitioning of a given string.

// Assumptions

// The given string is not null
// Examples

// “a | babbbab | bab | aba” is a palindrome partitioning of “ababbbabbababa”.

// The minimum number of cuts needed is 3.

// High Level: this is a DP problem 

// Details:
// 1. Divide the whole string into two part: larger left part + smaller right part
// 2. Use M[i] to save minimum cut to make substring [0,i] a palindrome partitioning.
// 3. Base case: M[0] = 0;(one letter string is a palindrome) 
// 4. Induction rule: M[i] = 0, if substring [0,i] is palindrome.
//                           min(M[j-1])+1, for j from 1 to i && if substring[j,i] is a palindrome (two part [0,j-1] and [j, i])
// 5. result return M[M.length-1];

// Code:
public class Solution{
    public int minCut(String str){
        //corner case
        if(str==null|| str.length()<=1) return 0;
        //M[i] is minimum cut to make substring [0,i] a palindrome partitioning.
        int[] M = new int[str.length()];
        //base case
        M[0]=0;
        for(int i = 1; i<str.length(); i++){
            //cut between 0 and i, two parts [0,j-1], [j,i]
            if(valid(str, 0, i)){
                //coner case: if j==0 is valid, means [0,i] is a palindrome partitioning already
                M[i]=0;
            }else{
                M[i] = i;
                for(int j=1;j<=i;j++){
                    //check left part[0,j-1] from M, check right part [j,i] using valid function
                    if(valid(str, j, i)){
                        M[i]= Math.min(M[j-1]+1, M[i]);
                    }
                }
            }
        }
        return M[str.length()-1];
    }
    //check if [left, right] is palindrome
    private boolean valid(String str, int left, int right){
        while(left<=right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            right--;
            left++;
        }
        return true;
    }
}

// Time O(n*n*n): n layers, and for each layer we need n*n 
// Space O(n): M[]
