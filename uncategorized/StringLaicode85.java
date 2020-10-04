//Laicode85 
//Determine if a small string is a substring of another large string.
//Return the index of the first occurrence of the small string in the large string.
//Method 1: Two Pointer Time O(n^2)
public class Solution {
  public int strstr(String large, String small) {
    if(large.length()<small.length())return -1;
    if(small.length()==0)return 0;
    for(int i=0;i<=large.length()-small.length();i++){
      if(equals(large, i, small)) return i;
    }
    return -1;
  }

  private boolean equals(String large, int start, String small){
    for(int i=0;i<small.length();i++){
      if(large.charAt(i+start)!=small.charAt(i)) return false;
    }
    return true;
  }
}

//To Do Rabin-Karp
public class Solution {
  public int strstr(String large, String small) {
    if(large==null || small==null || large.length() < small.length()) return -1;
    if(small.length()==0) return 0;
    int largePrime = 101;
    int prime = 31;
    int seed = 1;
    int targetHash = small.charAt(0)% largePrime;
    for(int i=1;i<small.length();i++){
      seed = moduleHash(seed,0,prime,largePrime);
      targetHash = moduleHash(targetHash,small.charAt(i),prime,largePrime);
    }
    int hash = 0;
    for(int i-0;i<small.length();i++){
      hash = moduleHash(targetHash,large.charAt(i),prime,largePrime);
    }
    if(hash == targetHash && equals(large,0,small)){
      return 0;
    }
    for(int i=1;i<=large.length()-small.length();i++){
      
    }

  }
}
