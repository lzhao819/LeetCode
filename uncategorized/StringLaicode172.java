//Laioffer 172 String Replace
//Hard
//Given an original string input, and two strings S and T, replace all occurrences of S in input with T.
public class Solution {
  public String replace(String input, String source, String target) {
    //Method1: using java StringBuilder and String's indexOf()
    //return replaceII(input, source, target);
    //Method2: using char array to do it in place
    return replaceI(input, source, target);
  }
  //Method1: using java StringBuilder and String's indexOf()
  private String replaceII(String string, String s, String t){
    StringBuilder sb = new StringBuilder();
    int fromIndex = 0;
    int matchIndex = string.indexOf(s, fromIndex);
    while(matchIndex!=-1){
      sb.append(string, fromIndex, matchIndex).append(t);
      fromIndex = matchIndex + t.length();
      matchIndex = string.indexOf(s,fromIndex);
    }
    sb.append(string, fromIndex, string.length());
    return sb.toString();
  }

  ///Method2: using char array to do it in place
  private String replaceI(String input, String s, String t){
    char[] array = input.toCharArray();
    if(s.length()>=t.length()){ 
      return replaceShort(array, s, t);
    }
    return replaceLong(array, s, t);
  }

  private String replaceShort(char[] string, String s, String t){
    int slow=0, fast=0;
    while(fast<string.length){
      //when find source string, copy to slow
      if(fast <= string.length-s.length() && equals(string, fast, s)){
        copy(string, slow, t);
        slow += t.length();
        fast += s.length();
      }else{
        string[slow++] = string[fast++];
      }
    }
    return new String(string,0,slow);
  }//

  private String replaceLong(char[] string, String s, String t){
  	//这种情况可以从右向左也可以从左向右inplace
  	//但是，实际上解题时可能会给我们一个已有预留位置的char array，而且input 已经从index = 0 的位置开始放在array里了，这时候就只能从右往左in-place改写。
    //get all the end position where char[] matches source
    ArrayList<Integer> matches = getMatches(string, s);
    //calculate the size of new larger array needed
    char[] result = new char[string.length + matches.size()*(t.length()-s.length())];
    //fast and slow both goes from right to left
    //lastSize is the rightmost matching end position
    int lastSize = matches.size();
    int fast = string.length-1;
    int slow = result.length-1;
    while(fast>=0){
      if(lastSize>0 && fast==matches.get(lastSize-1)){
        copy(result, slow-t.length()+1, t);
        slow -= t.length();
        fast -= s.length();
        lastSize--;
      }else{
        result[slow--]=string[fast--];
      }
    }
    return new String(result);
  }//

  private boolean equals(char[] string, int index, String s){
    for(int i=0; i<s.length(); i++){
      if(string[index+i]!=s.charAt(i)){
        return false;
      }
    }
    return true;
  }//

  private void copy(char[] string, int index, String t){
    for(int i=0; i<t.length(); i++){
      string[index+i]=t.charAt(i);
    }
  }//

  private ArrayList<Integer> getMatches(char[] string, String s){
    ArrayList<Integer> list = new ArrayList<Integer>();
    int i = 0;
    while(i<=string.length-s.length()){
      if(equals(string, i, s)){
        list.add(i+s.length()-1);
        i+=s.length();
      }else{
        i++;
      }
    }
    return list;
  }//
}