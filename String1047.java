//Leetcode1209. Remove All Adjacent Duplicates in String II
//Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.
//stack method

//two pointer method


//Laicode 79
//Remove adjacent, repeated characters in a given string, leaving only one character for each group of such characters.
public class Solution {
  public String deDup(String input) {
    if(input.length()==0) return input;
    char[] string = input.toCharArray();
    int fast=0,slow=0;
    while(fast<string.length){
      if(slow==0 || string[fast]!=string[fast-1]){
        string[slow++]=string[fast++];
      }else{
        fast++;
      }
    }
    return new String(string, 0, slow);
  }
}
