import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

class LeastKNumbersinArraySolution1 {
    /**
     * Quick Select
     * Space O(1)
     * Time O(N)
     * 要找下标为k的元素，第一次切分的时候需要遍历整个数组 (0 ~ n) 找到了下标是 j 的元素，
     * 如果 k 比 j 小，那么我们下次切分只要遍历数组 (0~k-1)的元素，
     * 反之如果 k 比 j 大，那下次切分只要遍历数组 (k+1～n) 的元素，
     * 总之可以看作每次调用 partition 遍历的元素数目都是上一次遍历的 1/2，因此时间复杂度是 N + N/2 + N/4 + ... + N/N = 2N, 因此时间复杂度是 O(N)
     *
     */
    Random rand = new Random();
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr==null || arr.length==0||k==0) return new int[0];

        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private int[] quickSearch(int[] nums, int left, int right, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, left, right);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k? quickSearch(nums, left, j - 1, k): quickSearch(nums, j + 1, right, k);
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    private int partition(int[] nums, int left, int right) {
        //random select piviot
        int piviotIndex = left+rand.nextInt(right-left+1);
        int piviot = nums[piviotIndex];
        //move piviot to the left
        swap(nums, piviotIndex, left);
        int i = left, j = right;

        while(i<=j){
            if(nums[i] <= piviot){
                i++;
            }else if(nums[j]>piviot){
                j--;
            }else{
                swap(nums, i, j);
            }
        }
        swap(nums, left, j);
        return j;
    }
    private void swap(int[] arr, int a, int b){
        int tmp  = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
class LeastKNumbersinArraySolution2 {
    /**
     * PriorityQueue
     * Time O(nlogk)
     * Space O(k)
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr==null || arr.length==0||k==0) return new int[0];
        PriorityQueue<Integer> max_heap = new PriorityQueue<>(k,(o1, o2)->o2-o1);
        for(int num:arr){
            if(max_heap.isEmpty()||max_heap.size()<k){
                max_heap.offer(num);
            }else if(num<max_heap.peek()){
                max_heap.poll();
                max_heap.offer(num);
            }
        }
        int[] result = new int[max_heap.size()];
        for(int i=result.length-1;i>=0;i--){
            result[i]=max_heap.poll();
        }
        return result;
    }

}

/**
 * 两种方法的比较
 * quick select在时间空间都由于堆，但是
 * 1 quick select需要修改原数组，如果原数组不能修改的话，还需要拷贝一份数组，空间复杂度变高。
 *
 * 2 算法需要保存所有的数据。如果把数据看成输入流的话，使用堆的方法是来一个处理一个，不需要保存数据，只需要保存 k 个元素的最大堆。而快速选择的方法需要先保存下来所有的数据，再运行算法。当数据量非常大的时候，甚至内存都放不下的时候，就麻烦了。所以当数据量大的时候还是用基于堆的方法比较好。
 */