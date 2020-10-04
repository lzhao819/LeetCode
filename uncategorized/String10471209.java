//Leetcode 1047 删两个 (和laicode82类似，但省去了删除后续连续的重复数字)
// choosing TWO adjacent and equal letters and remove.
//We repeatedly make duplicate removals on S until we no longer can.
//Two pointer and one of them is used as a stack
class Solution {
    public String removeDuplicates(String S) {
       if (S.length()==0)return S;
        char[] string = S.toCharArray();
        //using char[] as a stack
        //end is the top of the stack, when end ==-1, stack is empty
        int end=0;
        int fast=1;
        while(fast<string.length){
            if(end==-1||string[fast]!=string[end]){
                string[++end]=string[fast++];
            }else{
              //pop the top off the stack by end--;
              //ignore all the consecutive duplicate chars
              end--;
              fast++;
            }
        }
        return new String(string,0,end+1);
    }
}

//Leetcode1209. 删K个
//choosing K adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.
//Two pointers 
class Solution {
    public String removeDuplicates(String s, int k) {  
        int i = 0, n = s.length(), count[] = new int[n];
        char[] stack = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            stack[i] = stack[j];
            count[i] = i > 0 && stack[i - 1] == stack[j] ? count[i - 1] + 1 : 1;
            if (count[i] == k) i -= k;
        }
        return new String(stack, 0, i);
    }
}


//Laicode 79 留一个
//Remove adjacent, repeated characters in a given string, leaving only one character for each group of such characters.
//Two pointers
public class Solution {
  public String deDup(String input) {
    if(input.length()==0) return input;
    char[] string = input.toCharArray();
    int fast=0,slow=0;
    while(fast<string.length){
      if(slow==0 || string[fast]!=string[fast-1]){
        string[slow++]=string[fast++];
      }else{
        fast++;
      }
    }
    return new String(string, 0, slow);
  }
}

//Laicode 82 不留
//Remove all the adjacent repeate character
public class Solution {
  public String deDup(String input) {
    if (input.length()==0)return input;
        char[] string = input.toCharArray();
        //using char[] as a stack
        //end is the top of the stack, when end ==-1, stack is empty
        int end=0;
        int fast=1;
        while(fast<string.length){
            if(end==-1||string[fast]!=string[end]){
                string[++end]=string[fast++];
            }else{
              //pop the top off the stack by end--;
              //ignore all the consecutive duplicate chars
              end--;
              fast++;
              while(fast<string.length && string[fast]==string[fast-1]){
                fast++;
              }
            }
        }
        return new String(string,0,end+1);
  }
}
