//704 Classic Binary Search
class ClassicBinarySearch {
    public int search(int[] nums, int target) {
        //no need to consider coner case as it already been handled by l and r
        int l=0,r=nums.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }//while
        return -1;   
    }
}