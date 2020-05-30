//Laicode 175.Decompress String II
//Hard
Given a string in compressed form, decompress it to the original string. The adjacent repeated characters in the original string are compressed to have the character followed by the number of repeated occurrences.

Assumptions

The string is not null

The characters used in the original string are guaranteed to be ‘a’ - ‘z’

There are no adjacent repeated characters with length > 9

Examples

“a1c0b2c4” → “abbcccc”
public class Solution {
  //Method1: usding String Builder to help
  public String decompress(String input) {
    char[] array=input.toCharArray();
    StringBuilder sb = new StringBuilder();
    for(int i=0;i<array.length; i++){
      char ch = array[i++];
      int count = array[i] -'0';
      for (int c= 0; c< count; c++){
        sb.append(ch);
      }
    }
    return sb.toString();
  }

  //Method2: in place

}