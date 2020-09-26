package beautifulArrangement;
//https://leetcode.com/problems/beautiful-arrangement/
public class Solution {
     /*We try to create all the permutations of numbers from 1 to N.
     We can fix one number at a particular position and check for the divisibility criteria of that number at the particular position.
     But, we need to keep a track of the numbers which have already been considered earlier so that they aren't reconsidered while generating the permutations.
     If the current number doesn't satisfy the divisibility criteria, we can leave all the permutations that can be generated with that number at the particular position.

     Time O(k) k refers to the number of valid permutations.
     Space O(n)
      */
    int count = 0;
    public int countArrangement(int N) {
        boolean[] visited = new boolean[N+1];
        calculate(N, 1, visited);
        return count;
    }
    private void calculate(int N, int pos, boolean[] visited){
        if(pos>N){
            count++;
            return;
        }
        for(int i=1; i<=N; i++){
            if(!visited[i] && (pos%i == 0 || i%pos ==0)){
                visited[i]=true;
                calculate(N, pos+1, visited);
                visited[i]=false;
            }
        }
    }
}
