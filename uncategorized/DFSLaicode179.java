//Laicode 179. All Valid Permutations Of Parentheses II
// Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.

// Assumptions

// l, m, n >= 0
// l + m + n > 0
// Examples

// l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "(<>)", "<()>", "<>()"]
public class Solution {
  private static final char[] PS = new char[]{'(',')','<','>','{','}'};

  public List<String> validParentheses(int l, int m, int n) {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int[] remain = new int[]{l,l,m,m,n,n};
    int length = 2*(l+m+n);
    Deque<Character> stack = new ArrayDeque<Character>();
    DFS(result, sb, remain, length, stack);
    return result;
  }
  private void DFS(List<String> result, StringBuilder sb, int[] remain, int length, Deque<Character> stack){
    if(sb.length()==length){
      result.add(new String(sb));
      return;
    }
    for(int i = 0; i<remain.length; i++){
      if(i%2 == 0){
        //add left side
        if(remain[i]>0){
          sb.append(PS[i]);
          stack.offerFirst(PS[i]);
          remain[i]--;
          DFS(result, sb, remain, length, stack);
          sb.deleteCharAt(sb.length()-1);
          stack.pollFirst();
          remain[i]++;
        }
      }else{
        //add right side
        if(!stack.isEmpty() && stack.peekFirst() == PS[i-1]){
          sb.append(PS[i]);
          stack.pollFirst();
          remain[i]--;
          DFS(result, sb, remain, length, stack);
          sb.deleteCharAt(sb.length()-1);
          stack.offerFirst(PS[i-1]);
          remain[i]++;
        }
      }
    }//end for
  }
}

//Time O( 6^(2*(l+m+n)) )
//Space O(2*(l+m+n))
