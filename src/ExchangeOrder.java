
public class ExchangeOrder {
    public int[] exchange(int[] nums) {
        //two pointer
        //(nums[i] & 1) == 1) 奇数，位运算等价于取余
        if(nums==null||nums.length==0) return nums;
        int left=0, right = nums.length-1;
        while(left<=right){
            if(nums[left]%2==1){
                left++;
            }
            if(nums[right]%2==0){
                right--;
            }
            if(left<=right&&nums[left]%2==0&&nums[right]%2!=0){
                swap(nums,left, right);
                left++;
                right--;
            }
        }
        return nums;
    }
    private void swap(int[] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
    private void swapXOR(int[] nums, int a, int b){
        //交换数据也可以用位操作异或(^)，也不用开辟tmp空间
        /**
         * a ^ a = 0 ; 0 ^ a = a ; → a ^ ( a ^ b ) = a ^ a ^ b = 0 ^ b = b;
         * 例：交换a与b的值
         * a = a^b;
         * b = a^b; //b=a
         * a = a^b; //a=b
         **/
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }
}
