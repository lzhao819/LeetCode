import java.util.Arrays;

/**
 * merge sort
 * Time O(nlogn)
 * Space O(n)
 */
class reversePairsI {
    public int reversePairs(int[] nums) {
        if(nums.length<2) return 0;
        int[] copy = Arrays.copyOf(nums,nums.length);
        //全程采用一个数组tmp,原因有二：不必一直创建新的数组，节约资源；每次处理的都是子数组，如果创建新的数组会导致索引的处理很麻烦，容易出错
        int[] tmp = new int[nums.length];
        return reversePairs(copy, 0, nums.length-1, tmp);
    }
    private int reversePairs(int[] nums, int left, int right, int[] tmp){
        if(left==right){
            return 0;
        }
        int mid = left+(right-left)/2;
        int leftPairs = reversePairs(nums, left, mid, tmp);
        int rightPairs = reversePairs(nums, mid+1, right,tmp);
        if(nums[mid]<nums[mid+1]) return leftPairs+rightPairs;//左边子数组的最大数小于右边子数组的最小数，直接合并即可，不会产生逆序对
        int crossPairs = mergeAndCount(nums, left, mid, right, tmp);
        return leftPairs + rightPairs + crossPairs;
    }
    private int mergeAndCount(int[] nums, int left, int mid, int right, int[] tmp){
        for(int i=left;i<=right;i++) tmp[i] = nums[i];
        int i= left;
        int j = mid+1;
        int count = 0;
        for(int k=i;k<=right;k++){
            if(i==mid+1){//左边长度为0
                nums[k] = tmp[j];
                j++;
            }else if(j==right+1){//右边长度为0
                nums[k] = tmp[i];
                i++;
            }else if(tmp[i]<=tmp[j]){//左边存入数组
                nums[k] = tmp[i];
                i++;
            }else{
                nums[k] = tmp[j];//右边存入数组
                j++;
                count+=(mid-i+1);
            }
        }
        return count;
    }
}
/**
 * 离散化树状数组
 * 树状数组 是一种可以动态维护序列前缀和的数据结构，它的功能是：
 *
 * 单点更新 update(i, v)： 把序列 i 位置的数加上一个值 v，这题 v = 1
 * 区间查询 query(i)： 查询序列 [1⋯i] 区间的区间和，即 i 位置的前缀和
 * 修改和查询的时间代价都是 O(logn)，其中 n 为需要维护前缀和的序列的长度。
 * 来源：力扣（LeetCode）
 *
 */
