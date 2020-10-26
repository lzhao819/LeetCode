import java.util.HashSet;
import java.util.Set;

public class IsStraight {
    public boolean isStraight(int[] nums) {
        //需满足：
        //除大小王外，所有牌 无重复 ；
        //设此 5 张牌中最大的牌为 max - min<5 (大小王除外)
        Set<Integer> set = new HashSet<>();
        int max = 0, min = 14;
        for(int i : nums){
            if(i==0){
                continue;
            }
            min = Math.min(min, i);
            max = Math.max(max, i);
            if(set.contains(i)){
                return false;
            }else{
                set.add(i);
            }
        }
        return max-min<5;
    }
}
