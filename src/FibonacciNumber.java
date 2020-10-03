package src;
//509 Fibonacci Number
//DP2
//Time O(n)
//Space O(1)
class FibonacciNumber {
    public long fibonacci(int K) {
        long a=0;
        long b=1;
        if(K<=0) return a;
        while(K >1){
            long tmp =a+b;
            a=b;
            b=tmp;
            K--;
        }
        return b;
    }
}
//DP1
//Time O(n)
//Space O(n)
class Solution2 {
  public long fibonacci(int K) {
    if(K<=0){
      return 0;
    }
    long[] array = new long[K+1];
    array[1] = 1;
    for(int i=2; i<=K; i++){
      array[i] = array[i -2] + array[i-1];
    }
    return array[K];
  }
}

//Recursion
//Time O(N^2) Space O(N)
class Solution3 {
    public int fib(int N) {
        if(N==0) return 0;
        if(N==1) return 1;
        else return fib(N-1)+fib(N-2);
    }
}


