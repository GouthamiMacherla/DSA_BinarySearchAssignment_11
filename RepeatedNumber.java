/*
 * <aside>
💡 **Question 4**

Given an array of integers `nums` containing `n + 1` integers where each integer is in the range `[1, n]` inclusive.

There is only **one repeated number** in `nums`, return *this repeated number*.

You must solve the problem **without** modifying the array `nums` and uses only constant extra space.

**Example 1:**

```
Input: nums = [1,3,4,2,2]
Output: 2

```

**Example 2:**

</aside>
 * 
 */

package in.ineuron.gouthami;

public class RepeatedNumber {
    public static int findRepeatedNumber(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Detect the cycle using Floyd's Tortoise and Hare algorithm
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Find the entry point of the cycle (repeated number)
        int ptr1 = nums[0];
        int ptr2 = slow;
        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }

        return ptr1;
    }

    public static void main(String[] args) {
        // Testing the code
        int[][] testCases = {{1, 3, 4, 2, 2}, {3, 1, 3, 4, 2}};
        for (int[] nums : testCases) {
            int repeatedNumber = findRepeatedNumber(nums);
            System.out.println("Repeated number: " + repeatedNumber);
        }
    }
}

