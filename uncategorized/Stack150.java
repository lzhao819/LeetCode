//150 Evaluate Reverse Polish Notation
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for(String s : tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
                int b = stack.pollFirst();
                int a = stack.pollFirst();
                stack.offerFirst(cal(a,b,s));  
            }else{
                stack.offerFirst(Integer.valueOf(s));
            }    
        }
        return stack.peekFirst();
    }
    
    private int cal(int a, int b, String op){
        if(op.equals("+")){
            return a+b;
        }else if(op.equals("-")){
            return a-b;
        }else if(op.equals("*")){
            return a*b;
        }
        return a/b;
    }//
    
}