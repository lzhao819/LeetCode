/**
 * How to copy an array
 * We can avoid iteration over elements using clone() or System.arraycopy()
 *  clone() creates a new array of same size, but System.arraycopy() can be used to copy from a source range to a destination range.
 *  System.arraycopy() is faster than clone() as it uses Java Native Interface
 *  Arrays.copyOf();
 */

public class ShuffleanArray {
    class Solution {
        private int[] nums;
        private int[] oris;

        public Solution(int[] nums) {
            this.nums= new int[nums.length];
            this.oris= new int[nums.length];
            for(int i =0; i<nums.length;i++){
                this.nums[i] = nums[i];
                this.oris[i] = nums[i];
            }
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return oris;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            for(int i=nums.length;i>=1;i--){
                int j=(int)(Math.random()*i);
                swap(i-1, j);
            }
            return nums;
        }

        private void swap(int a, int b){
            int tmp = nums[a];
            nums[a] = nums[b];
            nums[b] = tmp;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */

}
