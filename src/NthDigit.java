public class NthDigit {
    /**
    1. find the length of the number where the nth digit is from
    2. find the actual number where the nth digit is from
    3. find the nth digit and return
    Time O(logn) ： 所求数位 n 对应数字 num 的位数 digit 最大为 O(logn) ；第一步最多循环 O(logn) 次；第三步中将 num 转化为字符串使用 O(logn) 时间；因此总体为 O(logn) 。
    Space O(logn) ： 将数字 num 转化为字符串 str(num) ，占用 O(logn) 的额外空间。
    */

    public int findNthDigit(int n) {
        int len = 1;
        long start = 1;
        long count = 9;
        while(n>len*count){
            n-=len*count;
            len+=1;
            start*=10;
            count*=10;
        }
        start+=(n-1)/len;// reduce 1 from n is to calibrate the difference between rank and natural number,because we start with 1
        return Long.toString(start).charAt((n-1)%len) -'0';
    }
}
