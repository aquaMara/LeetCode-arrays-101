package org.aquamara;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// Third Maximum Number
// 28/8/2023
// https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3231/
public class $ThirdMaximumNumber {

    public static void main(String[] args) {
        int i0 = thirdMax(new int[]{1,5,5,3,6,2,6,10,3,2,1});
        int i10 = thirdMax(new int[]{3, 2, 1});
        int i11 = thirdMax(new int[]{1, 2});
        int i12 = thirdMax(new int[]{2, 2, 3, 1});
        List<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");

        List<String> c = colors.stream().limit(2).collect(Collectors.toList());
        c.add("JHjh");
        System.out.println();
    }

    public static int thirdMax(int[] nums) {
        Integer max = null;
        Integer secondMax = null;
        Integer thirdMax = null;

        for (int num : nums) {

            if (Objects.equals(max, num) || Objects.equals(secondMax, num) || Objects.equals(thirdMax, num))
                continue;

            if (max == null || num > max) {
                thirdMax = secondMax;
                secondMax = max;
                max = num;
            } else if (secondMax == null || num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            } else if (thirdMax == null || num > thirdMax) {
                thirdMax = num;
            }
        }

        return thirdMax != null ? thirdMax : max;
    }
}

/*
Given an integer array nums, return the third distinct maximum number in this array.
If the third maximum does not exist, return the maximum number.

Example 1:
Input: nums = [3,2,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.

Example 2:
Input: nums = [1,2]
Output: 2
Explanation:
The first distinct maximum is 2.
The second distinct maximum is 1.
The third distinct maximum does not exist, so the maximum (2) is returned instead.

Example 3:
Input: nums = [2,2,3,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together since they have the same value).
The third distinct maximum is 1.

Constraints:
1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1

Follow up: Can you find an O(n) solution?
 */
