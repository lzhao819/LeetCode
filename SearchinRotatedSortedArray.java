// Given an integer array nums sorted in ascending order, and an integer target.

// Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

// You should search for target in nums and if you found return its index, otherwise return -1.

//Time O(logn)
//Space O(1)
public public int search(int[] nums, int target) {
    if(nums==null || nums.length==0) return -1;
    //binary search to find the index of smallest value
    int l =0, r =nums.length-1;
    while(l<r){
        int mid = l+(r-l)/2;
        if(nums[mid] > nums[r]){
            l=mid+1;
        }else{
            r=mid;
        }
    }
    //index of smllest is the places that rotate
    //binary search again to find the target
    int smIndex = l;
    l=0;
    r= nums.length-1;
    while(l<=r){
        int mid = l+(r-l)/2;
        int realmid = (mid+smIndex) % nums.length;
        if(nums[realmid]==target){
            return realmid;
        }else if(nums[realmid]<target){
            l=mid+1;
        }else{
            r=mid-1;
        }
    }
    return -1;  
}class SearchinRotatedSortedArray {
    
}