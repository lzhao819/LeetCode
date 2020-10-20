import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Method1: HashMap
 * Method2: LinkedHashMap
 * 相比于方法一，方法二减少了第二轮遍历的循环次数。当字符串很长（重复字符很多）时，方法二则效率更高
 */

class firstUniqCharI {
    //HashMap
    //Time O(n) Space O(1)
    public char firstUniqChar(String s) {
        if(s==null) return ' ';
        Map<Character, Boolean> map = new HashMap<>();
        char[] arr = s.toCharArray();

        for(char c:arr){
            map.put(c, !map.containsKey(c));
        }
        for(char c:arr){
            if(map.get(c)){
                return c;
            }
        }
        return ' ';
    }
}
class firstUniqCharII {
    // LinkedHashMap
    // Time O(n) Space O(1)
    public char firstUniqChar(String s) {
        Map<Character, Boolean> map = new LinkedHashMap();
        char[] arr = s.toCharArray();
        for(char c:arr){
            map.put(c, !map.containsKey(c));
        }
        for(Map.Entry<Character, Boolean> e : map.entrySet()){
            if(e.getValue()) return e.getKey();
        }
        return ' ';
    }
}


