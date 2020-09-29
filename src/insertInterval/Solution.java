package insertInterval;

import java.util.ArrayList;
import java.util.List;

//LeetCode 526
public class Solution {
    public int[][] insertInterval(int[][] intervals, int[] newInterval) {
        if(intervals.length==0) return new int[][]{newInterval};
        List<int[]> rst = new ArrayList<>();
        int i=0, n=intervals.length;

        while(i<n && intervals[i][1] < newInterval[0]){
            rst.add(intervals[i]);
            ++i;
        }
        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0]=Math.min(intervals[i][0],newInterval[0]);
            newInterval[1]=Math.max(intervals[i][1], newInterval[1]);
            ++i;
        }
        rst.add(newInterval);
        while(i<n){
            rst.add(intervals[i]);
            ++i;
        }
        return rst.toArray(new int[rst.size()][]);
    }
}
