//338 Counting Bits
class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        for(int i=0;i<=num;i++){
            int tmp = i;
            int count=0;
            while(tmp!=0){
                count+=(tmp&1);
                tmp>>>=1;
            }
            result[i]=count;
        }
        return result;
    }
}