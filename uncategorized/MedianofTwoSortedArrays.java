// Given two sorted arrays nums1 and nums2 of size m and n respectively.

// Return the median of the two sorted arrays.
//Time O(log(m+n))
//Space O(1)
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m+n+1)/2; //left half of enire two arrays
        int right = (m+n+2)/2; //right half off the entire two arrays
        return (findKth(nums1,0,nums2,0,left) + findKth(nums1,0,nums2,0,right)) / 2.0;  
    }
    private double findKth(int[] nums1, int start1, int[]nums2, int start2, int k){
        //corner cases
        //when nothing left in nums1, find kth in nums2
        if(start1>=nums1.length) return nums2[start2+k-1];
        if(start2>=nums2.length) return nums1[start1+k-1];
        if(k==1) return Math.min(nums1[start1], nums2[start2]);
        
        //compare and delete 前k/2
        int midIndex1 = start1+k/2-1;
        int midIndex2 = start2+k/2-1;
        
        int midVal1 = midIndex1<nums1.length ? nums1[midIndex1] : Integer.MAX_VALUE;
        int midVal2 = midIndex2<nums2.length ? nums2[midIndex2] : Integer.MAX_VALUE;
        
        if(midVal1<=midVal2){
            //delete from nums1
            return findKth(nums1, midIndex1+1, nums2, start2, k-k/2);
        }else{
            return findKth(nums1, start1, nums2, midIndex2+1, k-k/2);
        }  
    }
    
}