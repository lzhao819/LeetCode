//Laicode77 All Unique Characters II
//medium
// Determine if the characters of a given string are all unique.

// Assumptions

// We are using ASCII charset, the value of valid characters are from 0 to 255
// The given string is not null
public class Solution {
  public boolean allUnique(String word) {
    char[] array = word.toCharArray();
    int[] vector = new int[8];
    for(char c:array){
      //c range from 0-255
      //mapped to c/32 as the integer(index), c%32 as the bit position
      if((vector[c/32] >>> (c%32) & 1) !=0){
        return false;
      }
      vector[c/32] |= 1 <<(c%32);
    }
    return true;
  }
}