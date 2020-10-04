//75 Sort Colors
//rainbow sort
class Solution {
    public void sortColors(int[] nums) {
        if(nums==null || nums.length<=1) return;
        
        int i=0, j=0, k=nums.length-1;
        while(j<=k){
          if(nums[j]==0){
            swap(nums, j++, i++);
          }else if(nums[j]==1){
            j++;
          }else if(nums[j]==2){
            swap(nums, j, k--);
          }
        }
        return;
      }


      private void swap(int []array, int a, int b){
        int temp=array[a];
        array[a]=array[b];
        array[b]=temp;
      }

}