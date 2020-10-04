//LeetCode 953. Verifying an Alien Dictionary

//time O(n)
//space O(1)
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length<=1){
            return true;
        }
        int[] index = new int[26];
        for(int i=0; i<order.length();i++){
            index[order.charAt(i)-'a'] = i;
        }
        for(int i=1; i<words.length;i++){
            if(bigger(index, words[i-1], words[i])){
                return false;
            }
        }
        return true;
    }
    
    private boolean bigger(int[] index, String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        for(int i=0;i<m&&i<n;i++){
            if(s1.charAt(i)!= s2.charAt(i)){
                return index[s1.charAt(i)-'a']>index[s2.charAt(i)-'a'];
            }
        }
        return n>m;
        
    }
}