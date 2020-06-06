//Laicode100 Edit Distance
// Given two strings of alphanumeric characters, determine the minimum number of Replace, Delete, and Insert operations needed to transform one string into the other.

// Assumptions

// Both strings are not null
// Examples

// string one: “sigh”, string two : “asith”

// the edit distance between one and two is 2 (one insert “a” at front then replace “g” with “t”).
public class Solution {
  public int editDistance(String one, String two) {
    //use distance[][] to represent substring(0,i) in one and (0,j) in two
    int[][] distance = new int[one.length()+1][two.length()+1];
    for(int i=0; i<=one.length();i++){
      for(int j=0;j<=two.length();j++){
        if(i==0){
          distance[i][j]=j;
        }else if(j==0){
          distance[i][j]=i;
        }else if(one.charAt(i-1)==two.charAt(j-1)){
          distance[i][j]=distance[i-1][j-1];
        }else{
          distance[i][j] = Math.min(distance[i-1][j]+1, distance[i][j-1]+1);
          distance[i][j] = Math.min(distance[i][j], distance[i-1][j-1]+1);
        }
      }
    }//for
    return distance[one.length()][two.length()];
  }
}
