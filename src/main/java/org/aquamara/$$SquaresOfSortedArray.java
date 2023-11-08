package org.aquamara;

import java.util.Arrays;

// Squares of a Sorted Array
// 28/8/2023
// https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3240/
public class $$SquaresOfSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-5, -3, -2, -1})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{0, 1, 2, 3})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(sortedSquares(new int[]{-7, -3, 2, 3, 11})));
    }

    public static int[] sortedSquares(int[] nums) {
        int length = nums.length;
        int positivePointer = 0;

        while (positivePointer < length && nums[positivePointer] < 0)
            ++positivePointer;

        int negativePointer = positivePointer - 1;

        int[] sortedSquares = new int[length];
        int index = 0;

        while (negativePointer >= 0 && positivePointer < length) {
            if (nums[negativePointer] * nums[negativePointer] < nums[positivePointer] * nums[positivePointer]) {
                sortedSquares[index++] = nums[negativePointer] * nums[negativePointer];
                --negativePointer;
            } else {
                sortedSquares[index++] = nums[positivePointer] * nums[positivePointer];
                ++positivePointer;
            }
        }

        while (negativePointer >= 0) {
            sortedSquares[index++] = nums[negativePointer] * nums[negativePointer];
            --negativePointer;
        }

        while (positivePointer < length) {
            sortedSquares[index++] = nums[positivePointer] * nums[positivePointer];
            ++positivePointer;
        }

        return sortedSquares;
    }

    public static int[] sortedSquares1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        return nums;
    }
}

/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

Constraints:
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.

Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?
*/
