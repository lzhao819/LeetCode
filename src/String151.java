import java.util.ArrayList;
import java.util.List;

//151 Reverse Words in a String
class ReverseWordsArr {
    public String reverseWords(String s) {
        if (s == null) return s;
        char[] string = s.toCharArray();
        //reverse string
        reverse(string, 0, string.length-1);

        //reverse word
        int start=0;
        for(int i=0; i<string.length; i++){
          //the start index of a word
          if(string[i]!=' ' && (i==0 || string[i-1]==' ')){
            start = i;
          }
          //the end index of a word
          if(string[i]!=' ' && (i == string.length-1 || string[i+1]==' ')){
            reverse(string, start, i);
          }
        }
        
        //remove initial and inbetween spaces
        int end=0;
        for(int i=0; i<string.length; i++){
            if(string[i]==' '&& (i==0 || string[i-1]==' ')){
                continue;
            }
            string[end++]=string[i];
        }
        //remove tail spaces
        if(end>0 && string[end - 1] == ' '){
            end--;
        }
        
        //String(byte[] bytes, int offset, int length)
        return new String(string, 0, end);
    }

    private void reverse(char[] s, int l, int r){
      while(l<r){
        char tmp = s[l];
        s[l] = s[r];
        s[r] = tmp;
        l++;
        r--;
      }   
    }
        
}
//慢
class ReverseWordsStr {
    public String reverseWords(String s){
         String[] arr = s.trim().split("\\s+");
         List<String> list = new ArrayList<>();
         for(int i=arr.length-1; i>=0; i--){
             list.add(arr[i]);
         }
         return String.join(" ", list);
    }

}