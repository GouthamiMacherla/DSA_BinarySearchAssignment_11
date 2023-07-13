/*
 * <aside>
💡 **Question 7**

Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given `target` value.

If `target` is not found in the array, return `[-1, -1]`.

You must write an algorithm with `O(log n)` runtime complexity.

**Example 1:**

```
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

```

**Example 2:**

```
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

```

**Example 3:**

</aside>
 * 
 */


package in.ineuron.gouthami;

public class FindRange {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        int leftIndex = binarySearch(nums, target, true);
        if (leftIndex == nums.length || nums[leftIndex] != target) {
            return result;
        }

        int rightIndex = binarySearch(nums, target, false) - 1;

        result[0] = leftIndex;
        result[1] = rightIndex;
        return result;
    }

    public static int binarySearch(int[] nums, int target, boolean isLeft) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target || (isLeft && nums[mid] == target)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        // Testing the code
        int[][] testCases = {
                {5, 7, 7, 8, 8, 10},
                {5, 7, 7, 8, 8, 10},
                {1, 2, 3, 4, 5},
                {1, 2, 3, 4, 5},
                {2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2},
        };
        int[] targets = {8, 6, 5, 6, 2, 3, 1, 4};

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];
            int target = targets[i];

            int[] range = searchRange(nums, target);
            System.out.println("Target: " + target + ", Range: [" + range[0] + ", " + range[1] + "]");
        }
    }
}


