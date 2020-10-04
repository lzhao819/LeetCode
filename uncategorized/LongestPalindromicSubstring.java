//LeetCode 5. Longest Palindromic Substring
//Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//Time O(N^2) 
class Solution {
    public String longestPalindrome(String s) {
        String max = "";
        if(s==null ||s.length()<1) return max;
		for(int i = 0; i < s.length(); i++){
			String s1 = extend(s, i, i);
			String s2 = extend(s, i, i + 1);
			if(s1.length() > max.length()){
				max = s1;
			}
			if(s2.length() > max.length()){
				max = s2;
			}
		}
		return max;
	}
	public static String extend(String s, int i, int j){
		while(i >= 0 && j < s.length()){
			if(s.charAt(i) != s.charAt(j)){
				break;
			}
			i--;
			j++;
		}

		return s.substring(i + 1, j);
    }
}