/*
 * <aside>
💡 **Question 5**

Given two integer arrays `nums1` and `nums2`, return *an array of their intersection*. Each element in the result must be **unique** and you may return the result in **any order**.

**Example 1:**

```
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

```

**Example 2:**

</aside>
 * 
 */

package in.ineuron.gouthami;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayIntersection {
    public static int[] findIntersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        Set<Integer> intersection = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                intersection.add(num);
            }
        }

        int[] result = new int[intersection.size()];
        int i = 0;
        for (int num : intersection) {
            result[i++] = num;
        }

        return result;
    }

    public static void main(String[] args) {
        // Testing the code
        int[][][] testCases = {
                {{1, 2, 2, 1}, {2, 2}},
                {{4, 9, 5}, {9, 4, 9, 8, 4}}
        };

        for (int[][] testCase : testCases) {
            int[] nums1 = testCase[0];
            int[] nums2 = testCase[1];

            int[] intersection = findIntersection(nums1, nums2);

            System.out.print("Intersection: [");
            for (int i = 0; i < intersection.length; i++) {
                System.out.print(intersection[i]);
                if (i < intersection.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}

