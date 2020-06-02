//405 Convert a Number to Hexadecimal
class Solution {
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        if(num == 0){
            return "0";
        }
        while ((num) != 0){
            int n = num & 0xf;
            n += n < 0xa ? '0' : 'a' - 10;
            sb.append((char)n);
            num >>>=4;
        } 
        return sb.reverse().toString();     
    }
        
}