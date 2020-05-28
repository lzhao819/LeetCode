//344 Reverse String
class Solution {
    public void reverseString(char[] s) {
        if (s==null) return;
        int i=0, j=s.length-1;
        while(i<j){
            swap(s,i++,j--);
        }
        return;
    }
    private void swap(char[] s, int i, int j){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
  
}