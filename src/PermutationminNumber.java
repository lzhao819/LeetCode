import java.util.Arrays;

//Time O(nlogn)
//Space O(n)
// 重写 comparator x +y > y +x 则 x > y
public class PermutationminNumber {
    public String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            str[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(str, (a, b) -> (a+b).compareTo(b+a));
        StringBuilder sb = new StringBuilder();
        for(String s:str){
            sb.append(s);
        }
        return sb.toString();
    }
}
