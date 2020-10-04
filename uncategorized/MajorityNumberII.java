// Given an integer array of length L, find all numbers that occur more than 1/3 * L times if any exist.

// Assumptions

// The given array is not null
// Examples

// A = {1, 2, 1, 2, 1}, return [1, 2]
// A = {1, 2, 1, 2, 3, 3, 1}, return [1]
// A = {1, 2, 2, 3, 1, 3}, return []
 

public class MajorityNumberII {
    public List<Integer> majority(int[] array) {
        List<Integer> result = new ArrayList<>();
        if(array==null || array.length==0) return result;
        int a=array[0], b=array[0], acount=0, bcount=0;
        //iterate to choose two candidate
        for(int num:array){
          if(acount==0&&b!=num){
            a=num;
          }else if(bcount==0&&a!=num){
            b=num;
          }
          if(a==num){
            acount++;
          }else if(b==num){
            bcount++;
          }else{
            acount--;
            bcount--;
          } 
        }
        //iterate again to find the occurrance
        acount=0;
        bcount=0;
        for(int num:array){
          if(num==a){
            acount++;
          }else if(num==b){
            bcount++;
          }
        }
        if(acount>array.length/3){
          result.add(a);
        }
        if(bcount>array.length/3){
          result.add(b);
        }
        Collections.sort(result);
        return result;
      }
    
}