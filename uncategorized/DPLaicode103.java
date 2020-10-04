//Laicode103 Longest Consecutive 1s
public class Solution {
  public int longestI(int[] array) {
    //Two pointer
    if (array==null) return 0;
    int s=0, f=0;
    int globalmax=0;
    while(f<array.length){
      if(array[f]==1){
        globalmax=Math.max(globalmax, f-s+1);
        f++;
      }else{
        f++;
        s=f;
      }
    }
    return globalmax;
  }

  //DP
  public int longestI(int[] array) {
	int result = 0;
    int cur = array[0];
	for(int i=1;i<array.length;i++){
	  if(array[i]==1 && array[i-1]==0){
	    cur=1;
	  }else if(array[i]==1){
	    cur++;
	  }
	  result= Math.max(result, cur);
	}
	return result;
  }
}
