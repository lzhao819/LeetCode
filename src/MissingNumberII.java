public class MissingNumberII {
    public int missingNumber(int[] nums) {
        //index==num, 向右
        //index<num,向左
        //last occr of 相等
        //Time O(logn)
        //Space O(1)
        int l = 0, r = nums.length-1;
        while(l<r-1){
            int mid = l+(r-l)/2;
            if(nums[mid]>mid){
                r=mid;
            }else{
                l=mid;
            }
        }
        if(nums[r]==r){
            return r+1;
        }else if(nums[l]==l){
            return r;
        }else{
            return 0;
        }
    }
}
