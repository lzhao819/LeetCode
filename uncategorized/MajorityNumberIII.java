// Given an integer array of length L, find all numbers that occur more than 1/K * L times if any exist.

// Assumptions

// The given array is not null or empty
// K >= 2
// Examples

// A = {1, 2, 1, 2, 1}, K = 3, return [1, 2]
// A = {1, 2, 1, 2, 3, 3, 1}, K = 4, return [1, 2, 3]
// A = {2, 1}, K = 2, return []

/**
* we need to  quickly find if the number is available
* Hashmap, key: number   value: frequency
* for(i)
*
*  map.containsKey(array[i])
*      value++
*  not containsKey
*      put()
*  map.size() == k? true: all value --,  and remove count == 0
*
*  for(i)
*    check
*/
  //time O(n)
  //Space O(k)

public class MajorityNumberIII {
    public List<Integer> majority(int[] array, int k) {
        List<Integer> result = new ArrayList<>();
        if(array==null||array.length<=0) return result;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: array){
          Integer count = map.get(num);
          if(count==null){
            if(map.size()==k-1){
              reduce(map);
            }else{
              map.put(num,1);
            }
          }else{
            map.put(num, count+1);
          }
        }
        setZero(map);
        return getResult(map, array, k);
      }//
      private void reduce(Map<Integer, Integer> map){
        for(Integer key: map.keySet()){
          Integer count = map.get(key);
          map.put(key, count-1);
        }
        Iterator<Map.Entry<Integer, Integer>> iter = map.entrySet().iterator();
        while(iter.hasNext()){
          Map.Entry<Integer, Integer> cur = iter.next();
          if(cur.getValue()==0){
            iter.remove();
          }
        }
      }//    
      private void setZero(Map<Integer, Integer> map){
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
          entry.setValue(0);
        } 
      }//
      private List<Integer> getResult(Map<Integer, Integer> map, int [] array, int k){
        for(int num:array){
          Integer count = map.get(num);
          if(count!=null){
            map.put(num,count+1);
          }
        }
        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
          if(entry.getValue()*k>array.length){
            result.add(entry.getKey());
          }
        }
        return result;
      }// 
}