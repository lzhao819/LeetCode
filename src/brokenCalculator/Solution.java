package brokenCalculator;
//Leetcode 991
public class Solution {
    public int brokenCalculator(int X, int Y) {
        /*for X < Y, if we start from x, then we don't have a clue how should we pick -1 or *2
          but if we start from y, and look at it odd-eveness, then we would have a clue
          if y is odd, then the last operation must be -1, no other approaches
          if y is even, then we have two choices: -1 or * 2.
          To get last y from last second y2, we have two ways: y2 * 2 or y2 * 2 - 1 - 1
          y2 * 2 -1 - 1 = (y2-1) * 2, and (y2-1) * 2 can save us one operation.
          Hence for the last y, we will always pick /2 when it is even
       */
        //Time O(logY)
        //Space O(1)

        int result =0;
        while(Y>X){
            result++;
            if(Y%2==1){
                Y++;
            }else{
                Y=Y/2;
            }
        }
        return result + X-Y;
    }
}
