//Laicode63 All Subsets II(with duplicate)
// Given a set of characters represented by a String, return a list containing all subsets of the characters. Notice that each subset returned will be sorted to remove the sequence.

// Assumptions

// There could be duplicate characters in the original set.
// ​Examples

// Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
// Set = "abb", all the subsets are ["", "a", "ab", "abb", "b", "bb"]
// Set = "abab", all the subsets are ["", "a", "aa","aab", "aabb", "ab","abb","b", "bb"]
// Set = "", all the subsets are [""]
// Set = null, all the subsets are []

public class Solution {
  public List<String> subSets(String set) {
    List<String> result = new ArrayList<>();
    if(set==null) return result;
    char[] arr = set.toCharArray();
    //make sure the multi-set is sorted so that we can deduplicate
    Arrays.sort(arr);
    StringBuilder sb = new StringBuilder();
    DFS(arr, sb, 0, result);
    return result;
  }
  private void DFS(char[] arr, StringBuilder sb, int index, List<String> result){
    if(index==arr.length){
      result.add(sb.toString());
      return;
    }
    //case1: select current element
    DFS(arr, sb.append(arr[index]), index+1, result);
    sb.deleteCharAt(sb.length()-1);
    //skip the consecutive and duplicate elements
    while(index<arr.length-1 && arr[index] == arr[index+1]){
      index++;
    }
    //case2: not select current element
    DFS(arr, sb, index+1, result);
  }
}