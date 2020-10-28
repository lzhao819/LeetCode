public class SumNums {
    //逻辑运算符的短路效应!!
    public int sumNums(int n) {
        boolean flag = n>=1 && (n+=sumNums(n-1))>0;
        return n;
    }
}
