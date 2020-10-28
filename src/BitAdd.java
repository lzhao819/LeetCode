public class BitAdd {
    public int add(int a, int b) {
        while(b!=0){
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // 非进位和赋给a
            b = c; // 进位赋给b
        }
        return a;
    }
}
