//27 is  too simply, see the example below
//Remove Certain Characters
//Remove given characters in input string, the relative order of other characters should be remained. Return the new string after deletion.
public class Solution {
  public String remove(String input, String t) {
    if(input.length()==0 || t.length()==0)return input;
    char[] string = input.toCharArray();
    char[] sub = t.toCharArray();
    Set<Character> set = new HashSet<>();
    for(char a : sub){
      set.add(a);
    }
    int slow=0, fast=0;
    while(fast < string.length){
      if(!set.contains(string[fast])){
        string[slow++] = string[fast++];
        
      }else{
        fast++;
      }
    }
    return new String(string,0,slow);

    
  }
}

//27
class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length==0 )return 0;
        int slow=0, fast=0;
        while(fast < nums.length){
          if(nums[fast]!=val){
            nums[slow++] = nums[fast++];
          }else{
            fast++;
          }
        }
        return slow;      
    }
}