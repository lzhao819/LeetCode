//658. Find K Closest Elements
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //left is the cloest element to the target, i equal, is the first occurance position
        //right = left+1;
        //left and right should be the cloest two
        int left=binarySearch(arr,x);
        int right=left+1;
        int result[] = new int[k];
        for(int i=0;i<k;i++){
          if(right>=arr.length || left>=0 && x-arr[left]<=arr[right]-x){
            result[i]=arr[left--];
          }else{
            result[i]=arr[right++];
          }
        }
        Arrays.sort(result);
        
        List<Integer> list = new ArrayList<>();
        for(int num:result){
            list.add(num);
        }
        return list;
      }
    
      private int binarySearch(int[] array, int target){
        //first and closest
        int l=0,r=array.length-1;
        while(l<r-1){
          int mid = l+(r-l)/2;
          if(array[mid]>=target){
            r=mid;
          }else{
            l=mid;
          }
        }
        return Math.abs(array[l]-target) <= Math.abs(array[r]-target)? l:r;

    }
}