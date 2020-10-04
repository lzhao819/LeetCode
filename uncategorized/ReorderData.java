//LeetCode 937. Reorder Data in Log Files
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> myComp = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                int s1SpaceIndex = s1.indexOf(' ');
                int s2SpaceIndex = s2.indexOf(' ');
                char s1FirstChar = s1.charAt(s1SpaceIndex+1);
                char s2FirstChar = s2.charAt(s2SpaceIndex+1);
                
                //s1 is number
                if(s1FirstChar <='9'){
                    if(s2FirstChar <='9'){
                        //s1,s2 number
                        return 0;
                    }else{
                        //both letter
                        return 1;
                    }
                }
                
                //s1 letter, s2 num
                if(s2FirstChar <='9'){
                    return -1;
                }
                
                //both num
                int preCompute = s1.substring(s1SpaceIndex+1).compareTo(s2.substring(s2SpaceIndex+1));
                if(preCompute==0) return s1.substring(0,s1SpaceIndex).compareTo(s2.substring(0,s2SpaceIndex));
                return preCompute;
            }
        };
        
        Arrays.sort(logs, myComp);
        return logs;
    }
}