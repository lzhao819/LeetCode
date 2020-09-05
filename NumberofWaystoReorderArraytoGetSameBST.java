//Leetcode 1569. Number of Ways to Reorder Array to Get Same BST
//Time O(nlogn) - O(n^2)
//Space O(nlogn) - O(n^2)
class Solution {
    long MOD = (int)1e9+7;
    public int numOfWays(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        for(int i: nums){
            list.add(i);
        }
        return (int)getCombs(list, getTriangle(len+1))-1;   
    }
    private long getCombs(List<Integer> list, long[][] combs){
        if(list.size()<=2){
            return 1;
        }
        int root = list.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for(int n:list){
            if(n<root){
                left.add(n);
            }else if(n>root){
                right.add(n);
            }
        }
        return (combs[left.size()+right.size()][left.size()] * (getCombs(left, combs)%MOD ) % MOD) * getCombs(right, combs)%MOD;
    }
    private long[][] getTriangle(int n){
        //yanghui triangle
        //4C2 = triangle[4][2] = 6
        long[][] triangle = new long[n][n];
        for(int i=0;i<n;i++){
            triangle[i][0] = triangle[i][i] = 1;
        }
        for(int i=2; i<n;i++){
            for(int j=1;j<i;j++){
                triangle[i][j] = (triangle[i-1][j]+ triangle[i-1][j-1]) % MOD;
            }
        }
        return triangle;
    }
}
