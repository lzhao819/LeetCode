//611 Compress String II
//Hard
// Given a string, replace adjacent, repeated characters with the character followed by the number of repeated occurrences.

// Assumptions

// The string is not null

// The characters used in the original string are guaranteed to be ‘a’ - ‘z’

// Examples

// “abbcccdeee” → “a1b2c3d1e3”
public class Solution {
  public String compress(String input) {
    if(input == null || input.isEmpty()) return input;
    char[] array = input.toCharArray();
    return encode(array);
  }

  private String encode(char[] input){
    int sptr=0, fptr=0;
    int newLength = 0;
    //Step1: deal with the adjacent occur >=2
    while(fptr<input.length){
      int begin = fptr;
      while(fptr < input.length && input[fptr] == input[begin]){
        fptr++;
      }
      input[sptr++]=input[begin];
      if(fptr-begin ==1){
        newLength+=2;
      }else{
        int len = copyDigits(input, sptr, fptr- begin);
        sptr += len;
        newLength += len+1;
      }
    }
    //Step2: deal with the adjacent occur ==1
    //Notice: if it is required to do in place, usually the input array is large enough and don't need to allowcate large one.
    //This is for demostration only
    char[] result = new char[newLength];
    fptr = sptr-1;
    sptr = newLength-1;
    while(fptr>=0){
      if(Character.isDigit(input[fptr])){
        while(fptr>=0 && Character.isDigit(input[fptr])){
          result[sptr--] = input[fptr--];
        }
      }else{
        result[sptr--]='1';
      }
      result[sptr--] = input[fptr--];
    }
    return new String(result);
  }//

  //copy count as digits into input, starting at'index'
  private int copyDigits(char[] input, int index, int count){
    int len = 0;
    for(int i=count; i>0; i/=10){
      index++;
      len++;
    }
    for(int i=count; i>0; i/=10){
      int digit = i%10;
      input[--index] = (char)('0' + digit);
    }
    return len;
  }
}
