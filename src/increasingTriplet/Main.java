package increasingTriplet;

/*
        334. Increasing Triplet Subsequence
        Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

        Formally the function should:

        Return true if there exists i, j, k
        such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
        Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.

        Example 1:

        Input: [1,2,3,4,5]
        Output: true
        Example 2:

        Input: [5,4,3,2,1]
        Output: false
 */

public class Main {
    public static void main(String[] args) {
        int[] testTable = { 0, 1, 2, 3, 4, 5, 6, 10 };
//        for (int input : testTable) {
//            test(input);
//        }
        test(testTable);
    }

    private static void test(int[] input) {
        Solution solution = new Solution();
        boolean output;
        long begin = System.currentTimeMillis();
        output = solution.increasingTriplet(input);
        long end = System.currentTimeMillis();
        System.out.println(input + ":	output=" + output);
        System.out.println();
        System.out.println("耗时：" + (end - begin) + "ms");
        System.out.println("-------------------");
    }
}
