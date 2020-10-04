//84 Largest Rectangle in Histogram
class Solution {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        //the stack contains index, not the value
        Deque<Integer> stack = new LinkedList<>();
        
        for(int i=0;i<=heights.length;i++){
            //we need to pop all the elemt in stack, so we add 0 height for the last.
            int cur =( i==heights.length? 0: heights[i]);
            
            while(!stack.isEmpty() && heights[stack.peekFirst()]>=cur){
              int prevH = heights[stack.pollFirst()];
                
              //determine the left boundry of the larget rectangle 
              //with height of heights[i]
              int left = stack.isEmpty()? 0 : stack.peekFirst()+1;
                
              //determin the right boundry of the largest rectangle 
              //with height of the popped element
              result = Math.max(result, prevH*(i - left));
            }
            stack.offerFirst(i);
        }
        return result;
    }
}