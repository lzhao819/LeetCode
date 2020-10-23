public class SingleNumberIII {
    /**
     分成两组：相同的数字分在相同的组，不同的数字分在不同的组，每组分别异或就可以得到答案
     在全部数字异或值为1的位里随便取一位，取的这一位是0的分为一组，是1的分为另一组
     时间复杂度：O(n)，我们只需要遍历数组两次。
     空间复杂度：O(1)，只需要常数的空间存放若干变量。
     */
    public int[] singleNumbers(int[] nums) {
        int[] result = {0,0};
        int sum=0;
        for(int i:nums){
            sum ^=i;
        }
        //-sum=sum取反码+1 所以sum&（-sum）得到sum最后一位的1
        int lowbit = sum&(-sum);
        for(int i:nums){
            if((i&lowbit) ==0){
                result[0]^=i;
            }else{
                result[1]^=i;
            }
        }
        return result;
    }
}
