//Laicode 292 String Abbreviation Matching
// Word “book” can be abbreviated to 4, b3, b2k, etc. Given a string and an abbreviation, return if the string matches the abbreviation.

// Assumptions:

// The original string only contains alphabetic characters.
// Both input and pattern are not null.
// Pattern would not contain invalid information like "a0a","0".
// Examples:

// pattern “s11d” matches input “sophisticated” since “11” matches eleven chars “ophisticate”.
public class Solution {
  //Method1: recursion
  public boolean matchI(String input, String pattern) {
    return match(input, pattern, 0, 0);
  }
  private boolean match(String s, String t, int si, int ti){
    //only when we run out of s and t at the same time, there is a match
    if(si==s.length() && ti == t.length()){
      return true;
    }
    //if we run out of one of them but the other one has some letter left, false
    if(si>=s.length() || ti >=t.length()){
      return false;
    } 
    //case1: if current t is not a digit
    if(t.charAt(ti)<'0' || t.charAt(ti)>'9'){
      if(s.charAt(si) == t.charAt(ti)){
        return match(s,t,si+1, ti+1);
      }
      return false;
    }
    //case2: if current t is a digit, we need to find out the digit value
    //eg: "123" means number 123
    int count =0;
    while(ti<t.length() && t.charAt(ti)>='0' && t.charAt(ti)<='9'){
      count = count *10 + (t.charAt(ti)-'0');
      ti++;
    }
    return match(s,t,si+count,ti);
  }
  
  //Method2: Iterative
  //The above recursion is a tail reucrtion, is easy to convert to interative
  public boolean matchII(String input, String pattern) {
    int si=0, ti=0;
    while(si<input.length() && ti < pattern.length()){
      if(pattern.charAt(ti)<'0'||pattern.charAt(ti)>'9'){
        if(input.charAt(si) != pattern.charAt(ti)){
          return false;
        }
        si++;
        ti++;
      }else{
        int count =0;
        while(ti<pattern.length() && pattern.charAt(ti)>='0' && pattern.charAt(ti)<='9'){
          count = count*10 + (pattern.charAt(ti)-'0');
          ti++;
        }
        si+= count;
      }
    }
    return si == input.length() && ti == pattern.length();
  }//
}
