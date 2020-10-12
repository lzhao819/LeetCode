import java.util.PriorityQueue;
import java.util.Random;

//time O(n)
//space O(1)
class KthLargestElementinArraySolition1 {
    Random rand = new Random();
    public int findKthLargest(int[] nums, int k) {
        //coner case
        if(nums.length==0||k==0){
            return 0;
        }
        quickSearch(nums, 0, nums.length-1, k-1);
        return nums[k-1];
    }

    public void quickSearch(int[] array, int left, int right, int k){
        int j = partition(array, left, right);
        if(j==k) return;
        if(j>k){
            quickSearch(array, left, j-1, k);
        } else{
            quickSearch(array, j+1, right, k);
        }
    }

    private int partition(int[] array, int left, int right){
        int pivotIndex = left + rand.nextInt(right - left +1);
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, left);
        int i = left;
        int j = right;
        while (i <= j){
            if(array[i] >= pivot){
                i++;
            }else if(array[j] < pivot){
                j--;
            }else{
                swap(array, i, j);
            }
        }
        swap(array, left, j);
        return j;
    }

    private void swap(int [] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
class KthLargestElementinArraySolition2 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();

        for(int i=0;i<nums.length;i++){
            if(i<k){
                minHeap.offer(nums[i]);
            }else if(minHeap.peek()<nums[i]){
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
