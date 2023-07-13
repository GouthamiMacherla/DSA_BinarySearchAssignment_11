/*
 * <aside>
💡 **Question 8**

Given two integer arrays `nums1` and `nums2`, return *an array of their intersection*. Each element in the result must appear as many times as it shows in both arrays and you may return the result in **any order**.

**Example 1:**

```
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

```

**Example 2:**

```
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
```

</aside>
 * 
 */

package in.ineuron.gouthami;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayIntersection1 {
    public static int[] findIntersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> intersection = new ArrayList<>();
        for (int num : nums2) {
            if (countMap.containsKey(num) && countMap.get(num) > 0) {
                intersection.add(num);
                countMap.put(num, countMap.get(num) - 1);
            }
        }

        int[] result = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        // Testing the code
        int[][] testCases = {
                {1, 2, 2, 1},
                {4, 9, 5}
        };
        int[][] testCases2 = {
                {2, 2},
                {9, 4, 9, 8, 4}
        };

        for (int i = 0; i < testCases.length; i++) {
            int[] nums1 = testCases[i];
            int[] nums2 = testCases2[i];

            int[] intersection = findIntersection(nums1, nums2);

            System.out.print("Intersection: [");
            for (int j = 0; j < intersection.length; j++) {
                System.out.print(intersection[j]);
                if (j < intersection.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}

