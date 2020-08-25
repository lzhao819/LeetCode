// Create a timebased key-value store class TimeMap, that supports two operations.

// 1. set(string key, string value, int timestamp)

// Stores the key and value, along with the given timestamp.
// 2. get(string key, int timestamp)

// Returns a value such that set(key, value, timestamp_prev) was called previously, with timestamp_prev <= timestamp.
// If there are multiple such values, it returns the one with the largest timestamp_prev.
// If there are no values, it returns the empty string ("").
 
class TimeMap {
    Map<String, List<Pair<Integer, String>>> M;

    /** Initialize your data structure here. */
    public TimeMap() {
        M = new HashMap<>();   
    }
    
    // timestamps are always increasing so that we can use binary search
    public void set(String key, String value, int timestamp) {
        if(!M.containsKey(key)){
            M.put(key, new ArrayList<Pair<Integer, String>>());
        }
        M.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!M.containsKey(key)) return "";
        List<Pair<Integer, String>> A = M.get(key);
        return binarySearch(A, timestamp);
    }
    
    private String binarySearch(List<Pair<Integer, String>> list, int timestamp){
        int l = 0, r = list.size()-1;
        while(l<r-1){
            int mid = l+(r-l)/2;
            if(list.get(mid).getKey()>timestamp){
                r=mid;
            }else{
                l=mid;
            }
        }
        if(list.get(r).getKey()<=timestamp){
            return list.get(r).getValue();
        }else if(list.get(l).getKey()<=timestamp){
            return list.get(l).getValue();
        }
        return "";  
    }
        
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */