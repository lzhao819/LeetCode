//Leetcode 50 Pow(x, n)
class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(x==0) return 0;
        if(n==Integer.MIN_VALUE){
            // INT_MIN is -2147483648 but INT_MAX is 2147483647,so n = -n is failed, we has to do this seperatly
            x = x * x;
            n = n/2;
        }
        if(n<0){
            x=1.0/x;
            n=-n;
        }
        double temp=myPow(x,n/2);
        if(n%2==0) return temp*temp;
        return temp*temp*x; 
    }
}