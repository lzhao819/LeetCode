//Laicode397 Right Shift By N Characters
//eg: "abc", 4 -> "cab"
public class Solution {
  public String rightShift(String input, int n) {
    if(input.length()<=1) return input;
    
    char[] string = input.toCharArray();
    reverse(string, 0, string.length-1);
    reverse(string, 0, n%string.length -1);
    reverse(string, n%string.length, string.length-1);
    return new String(string);
  }

  private void reverse(char[] s, int l, int r){
    while(l<r){
      char tmp = s[l];
      s[l] = s[r];
      s[r] = tmp;
      l++;
      r--;
    }
    return;
  }
}


