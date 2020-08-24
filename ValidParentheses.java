//https://leetcode.com/problems/valid-parentheses/
//
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
           if(c=='(') {
               stack.offerLast(')');
           }else if(c=='{'){
               stack.offerLast('}');
           }else if(c=='['){
               stack.offerLast(']');   
           }else if(stack.isEmpty() || stack.pollLast()!=c){
               return false;
           }
        }
        return stack.isEmpty();
    }
}