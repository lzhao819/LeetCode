//Laicode 175.Decompress String II
//Hard
// Given a string in compressed form, decompress it to the original string. The adjacent repeated characters in the original string are compressed to have the character followed by the number of repeated occurrences.

// Assumptions

// The string is not null

// The characters used in the original string are guaranteed to be ‘a’ - ‘z’

// There are no adjacent repeated characters with length > 9

// Examples

// “a1c0b2c4” → “abbcccc”
public class Solution {
  //Method1: usding String Builder to help
  public String decompressI(String input) {
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
  public String decompressII(String input){
    if(input.isEmpty()) return input;
    char[] array = input.toCharArray();
    //we need to handle a0,a1,a2(the decoded string is shorter)
    //and a3,a4...(the decoded string is longer)
    return decodeLong(array, decodeShort(array));
  }
  //return the length of new string
  private int decodeShort(char[] input){
    //because the decoded string is shorter, we do it from left to right
    int end =0;
    for(int i=0;i<input.length;i+=2){
      int digit = getDigit(input[i+1]);
      if(digit>=0 && digit <=2){
        for(int j=0;j<digit;j++){
          input[end++] = input[i];
        } 
      }else{
        //we don't handel longer here
        input[end++]=input[i];
        input[end++]=input[i+1];
      }
    }
    return end;
  }//
  private String decodeLong(char[] input, int length){
    int newLength = length;
    for(int i=0;i<length;i++){
      int digit = getDigit(input[i]);
      if(digit>2 && digit <=9){
        newLength += digit-2;
      }
    }
    char[] result = new char[newLength];
    int end = newLength-1;
    for(int i =length-1; i>=0;i--){
      int digit = getDigit(input[i]);
      if(digit>2 && digit <=9){
        i--;
        for(int j=0; j<digit;j++){
          result[end--] = input[i];
        }
      }else{
        result[end--] = input[i];
      }
    }
    return new String(result);
  }//
  private int getDigit(char digit){
    return digit-'0';
  }//
}
