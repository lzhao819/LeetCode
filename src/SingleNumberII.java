import java.util.HashMap;
import java.util.Map;

class SingleNumberIIBit{
//To do
// https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/mian-shi-ti-56-ii-shu-zu-zhong-shu-zi-chu-xian-d-4/
}

class SingleNumberIIMap {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res =0;
        for(int i: nums){
            map.put(i,map.getOrDefault(i, 0)+1);
        }
        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            if(e.getValue()==1){
                return e.getKey();
            }
        }
        return -1;
    }
}
