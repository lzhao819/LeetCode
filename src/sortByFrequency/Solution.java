package sortByFrequency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//451. Sort Characters By Frequency
//Time O(n) Space O()
public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            //getOrDefault returns value mapped with the specified key, otherwise default value is returned.
            map.put(c, map.getOrDefault(c,0)+1);
        }
        List<Character>[] bucket = new List[s.length()+1];
        for(char key:map.keySet()){
            int freq = map.get(key);
            if(bucket[freq]==null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for(int indx = bucket.length-1; indx>=0; indx--){
            if(bucket[indx]!=null){
                for(char c:bucket[indx]){
                    for(int i=0; i<indx; i++){
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}
