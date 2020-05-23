//509 Fibonacci Number
//Recursion 
//Time O(N^2) Space O(N)
class Solution {
    public int fib(int N) {
        if(N==0) return 0;
        if(N==1) return 1;
        else return fib(N-1)+fib(N-2);
    }
}

//Iteration
//Time O(n) Space O(1)
class Solution {
    public int fib(int N) {
        if(N==0) return 0;
        if(N==1) return 1;
        int a = 0, b = 1;
		while(N-- > 1)
		{
			int sum = a + b;
			a = b;
			b = sum;
		}
        return b;
    }
}