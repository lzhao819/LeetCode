import java.util.ArrayDeque;
import java.util.Deque;
//LeetCode 946
/** Solution 1 Time O(n)
               Space O(n)
 */
class ValidateStackSequencesI {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int popIndex=0;
        int pushIndex=0;
        while(popIndex<popped.length && pushIndex<=pushed.length){
            if(!stack.isEmpty()&& popped[popIndex]==stack.peek()){
                stack.pop();
                popIndex++;
            }else{
                if(pushIndex==pushed.length)return false;
                stack.push(pushed[pushIndex++]);
            }
        }
        return popIndex == popped.length;
    }
}
/**Solution 2 Time O(n)
              Space O(1)
    Using pushed[] as a stack
 */
class ValidateStackSequencesII {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int popIndex=0;
        int pushIndex=0;
        for(int num :pushed){
            pushed[pushIndex++] = num;
            while(pushIndex>0 && pushed[pushIndex-1]==popped[popIndex]){
                popIndex++;
                pushIndex--;
            }
        }
        return popIndex == popped.length;
    }
}

