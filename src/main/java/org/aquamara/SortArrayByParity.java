package org.aquamara;

// Sort Array By Parity
// 20/8/2023
// https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3260/
public class SortArrayByParity {

    public static void main(String[] args) {
        sortArrayByParity(new int[]{2,8,1,2,4});
        sortArrayByParity(new int[]{3,1,2,4});
        sortArrayByParity(new int[]{0});
    }

    public static int[] sortArrayByParity(int[] nums) {
        int length = nums.length;
        int index = 0, swap = 0;

        for (int i = 0; i < length; i++) {
            if (nums[i] % 2 == 0) {
                swap = nums[index];
                nums[index] = nums[i];
                nums[i] = swap;
                ++index;
            }
        }

        return nums;
    }

    public static int[] sortArrayByParity1(int[] nums) {
        int evenIndex = 0, oddIndex = 0;
        int length = nums.length;
        int[] odds = new int[length];

        for (int i = 0; i < length; i++) {
            if (nums[i] % 2 == 0)
                nums[evenIndex++] = nums[i];
            else
                odds[oddIndex++] = nums[i];
        }

        while (oddIndex > 0) {
            nums[evenIndex++] = odds[--oddIndex];
        }

        return nums;
    }
}

/*
Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
Return any array that satisfies this condition.

Example 1:
Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

Example 2:
Input: nums = [0]
Output: [0]

Constraints:
1 <= nums.length <= 5000
0 <= nums[i] <= 5000
 */
