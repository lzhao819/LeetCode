//LeetCode 154
public class FindMinInRotatedSortedArrayII {
    //time O(nlogn)
    //space O(1)
    public int findMin(int[] nums) {
        if(nums==null) return 0;
        //binarySearch
        int l =0;
        int r = nums.length-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(nums[mid]<nums[r]){
                r=mid;
            }else if(nums[mid]>nums[r]){
                l=mid+1; 
            }else if(nums[mid]==nums[r]){
                r-=1;
            }     
        }
        return nums[l];
    }
}
