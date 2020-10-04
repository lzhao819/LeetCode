//Laicode 640 All Subsets of Size K (no duplication)
// Given a set of characters represented by a String, return a list containing all subsets of the characters whose size is K.

// Assumptions

// There are no duplicate characters in the original set.

// ​Examples

// Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].

// Set = "", K = 0, all the subsets are [""].

// Set = "", K = 1, all the subsets are [].

public class Solution {
  public List<String> subSetsOfSizeK(String set, int k) {
    List<String> result = new ArrayList<>();
    if(set==null) return result;
    char[] arr = set.toCharArray();
    StringBuilder sb = new StringBuilder();
    DFS(arr, sb, k, 0, result);
    return result;
  }
  private void DFS(char[] arr, StringBuilder sb, int k, int index, List<String> result){
    if(sb.length()==k){
      result.add(new String(sb));
      return;
    }
    //when finish determine all the element in the arr, we must return
    if(index==arr.length){
      return;
    }
    //add current element
    DFS(arr, sb.append(arr[index]), k, index+1, result);
    sb.deleteCharAt(sb.length()-1);
    //not add current element
    DFS(arr, sb, k, index+1, result);
  }
}