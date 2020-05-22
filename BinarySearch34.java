//34. Find First and Last Position of Element in Sorted Array
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[]{-1,-1};
        int[] result = new int[2];
        int l=0, r=nums.length-1;
        
        //find first position first
        while(l<r-1){//left neighbors right
          int mid = l+(r-l)/2;
          if(nums[mid]>=target){
            r=mid;
          }else{
            l=mid;
          }
        }//when jump out of the while loop, we got nums[l] and nums[r] two elements
        if(nums[l]==target){
          result[0] = l;
        }else if(nums[r]==target){
           result[0] = r;
        }else{
            return new int[]{-1,-1};
        }
        
        //find last position
        l=result[0];
        r=nums.length-1;
        while(l<r-1){//left neighbors right
            int mid=l+(r-l)/2;
            if(nums[mid]<=target){
                l=mid;
            }else{
                r=mid;
            }   
        }
        if(nums[r]==target){
            result[1] = r;
        }else{
            result[1] = l;
        }
        
        return result; 
    }
}
