import java.util.HashSet;
import java.util.Set;

//如果没有重复数字，那么正常排序后，数字i应该在下标为i的位置，所以思路是重头扫描数组，遇到下标为i的数字如果不是i的话，（假设为m),那么我们就拿与下标m的数字交换。在交换过程中，如果有重复的数字发生，那么终止返回ture

public class FindDuplicateNumber {
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
