//443. String Compression
//easy
class Solution {
    public int compress(char[] chars) {
        int indexResult = 0, index = 0;
        while(index < chars.length){
            char currentChar = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == currentChar){
                index++;
                count++;
            }
            chars[indexResult++] = currentChar;
            if(count != 1)
                for(char c : Integer.toString(count).toCharArray()) 
                    chars[indexResult++] = c;
        }
        return indexResult;     
    }
}