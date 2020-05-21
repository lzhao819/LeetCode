//349
//Each element in the result must be unique.
//Using two HashSet
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for(Integer i:nums1){
            set.add(i);
        }
        for(Integer j:nums2){
            if(set.contains(j)){
                intersect.add(j);
            }
        }

        int[] result= new int[intersect.size()];
        int index=0;
        for(Integer num:intersect){
            result[index++]=num;
        }
        return result;     
    }
}

//350
//Each element in the result should appear as many times as it shows in both arrays.
//If these two array are not sorted
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int a :nums1){
            if(map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }else{
                map.put(a,1);
            }
        }
       
        for(int a :nums2){
            if(map.containsKey(a)){
                list.add(a);
                map.put(a,map.get(a)-1);
                map.remove(a, 0);
            }
        }
       
        
        int[] result= new int[list.size()];
        for(int a=0;a<list.size();a++){
            result[a]=list.get(a);
        }
        return result;     
    }
}

//If these two array are sorted already
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();
        int i=0, j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                //result[index++]=nums1[i];
                list.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                i++;
            }
        }
        
        int[] result= new int[list.size()];
        for(int a=0;a<list.size();a++){
            result[a]=list.get(a);
        }
        return result;     
    }
}

