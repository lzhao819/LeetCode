public class Numberof1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        //时间复杂度 O(log_2 n)：循环内部O(1)；逐位判断需循环log2n 次;
        //其中 log2n 代表数字 n 最高位 1 的所在位数（例如 log_2(4)=2, log_2(16)= 4;
        // Space O(1)
        int result = 0;
        while(n!=0){
            result+= n&1;
            //>>>: 无符号右移，忽略符号位，空位都以0补齐
            n>>>=1;
        }
        return result;
    }
}
