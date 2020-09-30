import java.util.HashSet;
import java.util.Set;

public class findDuplicateNumber {
    //Solution1
    //Time O(n)
    //Space O(1)
    public int findDuplicate1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            //位置正确，先不用管
            if (i == nums[i])
                continue;
            //出现了重复，直接返回
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }
            //交换
            int temp = nums[nums[i]];
            nums[nums[i]] = nums[i];
            nums[i] = temp;
            //这里的i--是为了抵消掉上面的i++，
            //交换之后需要原地再比较
            i--;
        }
        return -1;
    }
    //Solution2
    //Time O(n)
    //Space O(n)
    public boolean containsDuplicate2(int[] nums) {
        if(nums==null) return false;
        Set<Integer> set = new HashSet<>(nums.length);
        for(int i:nums){
            if(set.contains(i)){
                return true;
            }else{
                set.add(i);
            }
        }
        return false;
    }
}
