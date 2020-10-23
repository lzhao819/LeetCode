import java.util.ArrayList;
import java.util.List;

/**
 * 利用双指针，left = 1,right = 2; sum记录left 与right 之间所有数字的和，
 * 接下来比较sum 与 target的关系，如果sum大，就说明需要减小一个值， 此时减掉一个left，
 * 如果sum小，说明需要继续增加right，然后将入的sum中，
 * 如果二者相等，就将left和right之间所有数字加入一个数组，并将这个数组存入一个list;
 * 到最后使用 list.toArray() 返回一个数组即可
 */
public class FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        int left=1, right=2;
        int sum = left+right;
        List<int[]> list = new ArrayList<int[]>();
        while(left<right&&right<target){
            if(sum<target){
                right++;
                sum+=right;
            }else if(sum>target){
                sum-=left;
                left++;
            }else{
                int[] arr = new int[right-left+1];
                for(int j=0;j<arr.length;j++){
                    arr[j]=left+j;
                }
                list.add(arr);
                sum-=left;
                left++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
