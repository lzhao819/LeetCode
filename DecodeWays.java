//91. Decode Ways
// A message containing letters from A-Z is being encoded to numbers using the following mapping:

// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Given a non-empty string containing only digits, determine the total number of ways to decode it.

class Solution {
    public int numDecodings(String s) {
        //M[i] is number to decode from 0-i
        if(s==null || s.length()<1) return 0;
        int[] M = new int[s.length()];
        if(s.charAt(0)=='0'){
            return 0;
        }
        M[0] = 1;
        for(int i=1;i<s.length();i++){
            int num = ((int)s.charAt(i)-'0')+((int)s.charAt(i-1)-'0')*10;
            if(s.charAt(i)!='0'){
                M[i] += M[i-1];
            }
    
           if(num>=10 && num<=26){
               if(i==1){
                   M[i]+=1;
               }else{
                   M[i] += M[i-2];
               }
               
            }
        }
        return M[s.length()-1];   
    }
}