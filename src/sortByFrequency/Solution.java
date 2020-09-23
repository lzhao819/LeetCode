package sortByFrequency;

import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

//451. Sort Characters By Frequency
/*  Given a string, sort it in decreasing order based on the frequency of characters.

    Solution1: priorityQueue
    Time O(nlogm) == O(n) in this problem
    m is the distinguish character, can be O(1) since only 26 letters.
    So the overall time complexity should be O(n), the same as the buck sort with less memory use.

    Solution2: bucket Sort
    Time O(n) Space O(n)
 */
public class Solution {
    //PQ solution
    public String PQFrequencySort(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> max_heap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        max_heap.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while(!max_heap.isEmpty()){
            Map.Entry e = max_heap.poll();
            for(int i=0; i<(int) e.getValue(); i++){
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }

    //bucket Sort solution
    public String bucketFrequencySort(String s) {
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
