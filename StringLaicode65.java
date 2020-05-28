//Laicode65 Permutations II
//This is string version, leetcode 47 is int array version
public class Solution {
  public List<String> permutations(String input) {
    List<String> result = new ArrayList<>();
    if(input == null) return result;
    char[] array = input.toCharArray();
    helper(array, 0, result);
    return result; 
  }

  private void helper(char[] string, int index, List<String> result){
    if(index == string.length){
      result.add(new String(string));
      return;
    }
    Set<Character> used = new HashSet<Character>();
    for(int i = index;i<string.length; i++){
      //used.add(string[i]) will return false if string[i] is already exist
      if(used.add(string[i])){
        swap(string, i, index);
        //go for next level
        helper(string, index+1, result);
        //do the clear opration while backtracking
        swap(string, i, index);
      }
    }
  }//

  private void swap(char[] string, int l, int r){
    char tmp = string[l];
    string[l]=string[r];
    string[r]=tmp;
  }
}
