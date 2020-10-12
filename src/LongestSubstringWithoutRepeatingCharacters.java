import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//3 Longest Substring Without Repeating Characters

/**
 * Solution 1: Two pointer sliding window + Hashset
 * Time O(n)
 * Space O(1)
 */
class LongestSubstringWithoutRepeatingCharactersI {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> distinct = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int result = 0;
        while(fast<s.length()){
            if(distinct.contains(s.charAt(fast))){
                distinct.remove(s.charAt(slow++));
            }else{
                distinct.add(s.charAt(fast++));
                result = Math.max(result, fast-slow);
            }
        }
        return result;
    }
}

/**
 * Solution 2: DP + HashMap
 * Time O(n)
 * Space O(1)
 */
class LongestSubstringWithoutRepeatingCharactersII{
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap();
        int result =0;
        int left = 0;
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            // 当前值已经出现过了，更新左边界
            if(map.containsKey(c)){
                // left = 当前值最后一次出现的地方 + 1 ，使得[left,right]无重复值, 需要取较大值
                left = Math.max(left,map.get(c)+1);
            }
            //更新最后出现的下标
            map.put(c, i);
            // [left,right]的长度
            result = Math.max(result, i - left + 1);
        }
        return result;
    }

}