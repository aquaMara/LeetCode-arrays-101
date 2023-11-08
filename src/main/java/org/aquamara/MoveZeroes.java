package org.aquamara;

// Move Zeroes
// 17/8/2023
// https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3157/
public class MoveZeroes {

    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
        moveZeroes(new int[]{0});
    }

    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        int index = 0;

        for (int i = 0; i < length; i++) {
            if (nums[i] != 0)
                nums[index++] = nums[i];
        }

        while (index != length)
            nums[index++] = 0;
    }
}

/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]

Constraints:
1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1

Follow up: Could you minimize the total number of operations done?
*/
