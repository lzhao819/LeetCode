//342 Power of Four
class Solution {
    public boolean isPowerOfFour(int num) {
        //greater than 0 && has only one 1 && 1 should be on odd position
        //0x55555555 is hex，1010101010101010101010101010101 in binary with a length of 32. To make sure the 1 locates in the odd location.
        return (num>0) && ((num&(num-1)) == 0) && ((num & 0x55555555)!=0);
        
    }
}