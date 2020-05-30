//3 Longest Substring Without Repeating Characters
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> distinct = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int longest = 0;
        while(fast<s.length()){
            if(distinct.contains(s.charAt(fast))){
                distinct.remove(s.charAt(slow++));
            }else{
                distinct.add(s.charAt(fast++));
                longest = Math.max(longest, fast-slow);
            }
        }
        return longest;  
    }
}