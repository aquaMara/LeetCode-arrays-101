package org.aquamara;

import java.util.Arrays;

// Height Checker
// 21/8/2023
// https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3228/
public class $$HeightChecker {

    public static void main(String[] args) {
        int i1 = heightChecker(new int[]{1,1,4,2,1,3});
        int i2 = heightChecker(new int[]{5,1,2,3,4});
        int i3 = heightChecker(new int[]{1,2,3,4,5});
    }

    public static int heightChecker(int[] heights) {
        // index == 1 as the minimum number is 1
        int index = 1, counter = 0;
        int length = heights.length;
        int[] heightsAmount = new int[101]; // max value is 100, it would be on 100 index, so length should be 101

        for (int height : heights) {
            ++heightsAmount[height];
        }

        for (int height : heights) {
            while (heightsAmount[index] == 0)
                ++index;

            if (index != height)
                ++counter;

            --heightsAmount[index];
        }

        return counter;
    }

    public static int heightChecker1(int[] heights) {
        int length = heights.length, swap = 0;
        int[] expected = Arrays.copyOf(heights, length);

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (expected[j] < expected[i]) {
                    swap = expected[j];
                    expected[j] = expected[i];
                    expected[i] = swap;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < length; i++) {
            if (expected[i] != heights[i])
                ++count;
        }

        return count;
    }

}

/*
A school is trying to take an annual photo of all the students.
The students are asked to stand in a single file line in non-decreasing order by height.
Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.
You are given an integer array heights representing the current order that the students are standing in.
Each heights[i] is the height of the ith student in line (0-indexed).
Return the number of indices where heights[i] != expected[i].

Example 1:
Input: heights = [1,1,4,2,1,3]
Output: 3
Explanation:
heights:  [1,1,4,2,1,3]
expected: [1,1,1,2,3,4]
Indices 2, 4, and 5 do not match.

Example 2:
Input: heights = [5,1,2,3,4]
Output: 5
Explanation:
heights:  [5,1,2,3,4]
expected: [1,2,3,4,5]
All indices do not match.

Example 3:
Input: heights = [1,2,3,4,5]
Output: 0
Explanation:
heights:  [1,2,3,4,5]
expected: [1,2,3,4,5]
All indices match.

Constraints:
1 <= heights.length <= 100
1 <= heights[i] <= 100
 */
