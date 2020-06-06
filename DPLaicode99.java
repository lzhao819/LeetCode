//Laicode99 Dictionary Word I
// Given a word and a dictionary, determine if it can be composed by concatenating words from the given dictionary.

// Assumptions

// The given word is not null and is not empty
// The given dictionary is not null and is not empty and all the words in the dictionary are not null or empty
// Examples

// Dictionary: {“bob”, “cat”, “rob”}

// Word: “robob” return false

// Word: “robcatbob” return true since it can be composed by "rob", "cat", "bob"
public class Solution {
  public boolean canBreak(String input, String[] dict) {
    //assumption: not null/ empty
    Set<String> dictSet = toSet(dict);
    //M[i] represent index(i-1) in the input, also can represent the substring(0,i)
    boolean[] M = new boolean[input.length()+1];
    M[0]=true;
    for(int i=1; i<M.length;i++){
      for(int j=0;j<i;j++){
        if(dictSet.contains(input.substring(j,i)) && M[j]){
          M[i] =true;
          break;
        }
      }
    }
    return M[M.length-1];
  }
  private Set<String> toSet(String[] dict){
    Set<String> dictSet = new HashSet<>();
    for(String s: dict){
      dictSet.add(s);
    }
    return dictSet;
  }//
}