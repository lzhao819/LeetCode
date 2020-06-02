//Laicode75 Number Of Different Bits
//Determine the number of bits that are different for two given integers.

//Examples

//5(“0101”) and 8(“1000”) has 3 different bits
public class Solution {
  public int diffBits(int a, int b) {
    a=a^b;//only different will be 1
    int count =0;
    while(a!=0){
      count += a&1;
      a>>>=1;//>>> 无符号右移，忽略符号位，空位都以0补齐
    }
    return count;
  }
}