//Laicode 292 String Abbreviation Matching
// Word “book” can be abbreviated to 4, b3, b2k, etc. Given a string and an abbreviation, return if the string matches the abbreviation.

// Assumptions:

// The original string only contains alphabetic characters.
// Both input and pattern are not null.
// Pattern would not contain invalid information like "a0a","0".
// Examples:

// pattern “s11d” matches input “sophisticated” since “11” matches eleven chars “ophisticate”.
public class Solution {
  public boolean match(String input, String pattern) {
    return match(input, pattern, 0, 0);
  }
  private boolean match(String s, String t, int si, int ti){
    if(si==s.length() && ti == t.length()){
      return true;
    }
    if(t.charAt(ti)<'0' || t.charAt(ti)>'9'){
      if(s.charAt(si) == t.charAt(ti)){
        return match(s,t,si+1, ti+1);
      }
      return false;
    }

    int count =0;
    while(ti<t.length() && t.charAt(ti)>='0' && t.charAt(ti)<='9'){
      count = count *10 + (t.charAt(ti)-'0');
      ti++;
    }
    return match(s,t,si+count, ti);
  }
}
