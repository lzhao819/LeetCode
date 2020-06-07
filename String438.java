//438 Find All Anagrams in a String
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s.length()==0) return result;
        if(s.length()<p.length()) return result;
        //the map is to record all the distinct characters in sh
        Map<Character, Integer> map = getMap(p);
        //record how many distinct char has not been matched
        //when match ==0, we get an anagram
        int match = map.size();
        for(int i=0;i<s.length();i++){
          char tmp = s.charAt(i);
          Integer count = map.get(tmp);
          if(count!=null){
            map.put(tmp, count-1);
            if(count==1){
              match--;
            }
          }
          //handel left
          if(i>=p.length()){
            tmp=s.charAt(i-p.length());
            count = map.get(tmp);
            if(count!=null){
              map.put(tmp, count+1);
              if(count ==0){
                match++;
              }
            }
          }
          if(match==0){
            result.add(i-p.length()+1);
          }
        }
        return result;
      }
      private Map<Character, Integer> getMap(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
          Integer count = map.get(ch);
          if(count==null){
            map.put(ch,1);
          }else{
            map.put(ch,count+1);
          }
        }
        return map;
      }//
}