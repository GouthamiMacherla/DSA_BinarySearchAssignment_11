/*
 * <aside>
💡 **Question 1**

Given a non-negative integer `x`, return *the square root of* `x` *rounded down to the nearest integer*. The returned integer should be **non-negative** as well.

You **must not use** any built-in exponent function or operator.

- For example, do not use `pow(x, 0.5)` in c++ or `x ** 0.5` in python.

**Example 1:**

```
Input: x = 4
Output: 2
Explanation: The square root of 4 is 2, so we return 2.

```

**Example 2:**

</aside>
 * 
 */
package in.ineuron.gouthami;

public class SquareRoot {
    public static int sqrt(int x) {
        if (x == 0) {
            return 0;
        }

        long start = 1;
        long end = x;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long square = mid * mid;

            if (square == x) {
                return (int) mid;
            } else if (square < x) {
                start = mid + 1;
                result = mid;
            } else {
                end = mid - 1;
            }
        }

        return (int) result;
    }

    public static void main(String[] args) {
        // Testing the code
        int[] testCases = {4, 8, 25};
        for (int x : testCases) {
            int squareRoot = sqrt(x);
            System.out.println("Square root of " + x + ": " + squareRoot);
        }
    }
}

