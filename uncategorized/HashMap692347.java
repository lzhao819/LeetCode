//692
//String
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        //if the input array is empty
        if(words.length==0) return result;
        //put into hash map
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++)
        {
            if(map.containsKey(words[i]))
                map.put(words[i], map.get(words[i])+1);
            else
                map.put(words[i], 1);
        }//for
        
        //MinHeap to keep k, override PriorityQueue to compare map value directly
        //using Map.Entry as the element type to make all the operation most efficient
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
                return e1.getValue()==e2.getValue()? e2.getKey().compareTo(e1.getKey()) : e1.getValue()-e2.getValue();
            } 
        });
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            minHeap.offer(entry);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }//for
        
        //put result in heap to the list
        while(!minHeap.isEmpty())
            result.add(0, minHeap.poll().getKey());
        
        return result;
    }
}

//347
//int
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length==0) return new int[0];
        int[] result= new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }//for
        
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2){
                return e1.getValue().compareTo(e2.getValue());
            } 
        });
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            minHeap.offer(entry);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        } 
        
        for(int i=k-1;i>=0;i--){
            result[i]=minHeap.poll().getKey();
        }
        
        return result;
    }
}
