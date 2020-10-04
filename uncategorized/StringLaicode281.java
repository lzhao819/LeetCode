// Remove spaces
// Given a string, remove all leading/trailing/duplicated empty spaces.

// Assumptions:

// The given string is not null.
// Examples:

// “  a” --> “a”
// “   I     love MTV ” --> “I love MTV”
public class Solution {
  public String removeSpaces(String input) {
   if(input.length()==0) return input;
   
   int fast=0, slow=0;
   char[] string = input.toCharArray();
   
   while(fast<string.length){
     if(string[fast]==' '&& (fast==0 || string[fast-1]==' ')){
       fast++;
     }else{
       string[slow++]=string[fast++];
    }
   }
   if(slow>0 && string[slow-1]==' ') slow--;
   String result = new String(string,0,slow);
   return result;
   }
}