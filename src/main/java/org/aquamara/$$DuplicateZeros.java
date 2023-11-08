package org.aquamara;

import java.util.Arrays;

// Duplicate Zeros
// https://leetcode.com/explore/learn/card/fun-with-arrays/525/inserting-items-into-an-array/3245/
public class $$DuplicateZeros {

    public static void main(String[] args) {
        duplicateZeros(new int[]{1,0,2,3,0,4,5,0});
        duplicateZeros(new int[]{1,0,2,0,0,6,5,8});
        duplicateZeros(new int[]{1,2,3});
    }

    public static void duplicateZeros(int[] arr) {
        int[] unchangeable = Arrays.copyOf(arr, arr.length);
        int index = 0;
        for (int i = 0; index < unchangeable.length; i++) {
            if (unchangeable[i] != 0) {
                arr[index++] = unchangeable[i];
            } else {
                arr[index++] = unchangeable[i];
                if (index == unchangeable.length)
                    break;
                arr[index++] = unchangeable[i];
            }
        }
    }

    public static void duplicateZeros1(int[] arr) {
        int length = arr.length;
        for (int i = length - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                for (int j = length - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
            }
        }
    }
}

/*
Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
Note that elements beyond the length of the original array are not written.
Do the above modifications to the input array in place and do not return anything.

Example 1:
Input: arr = [1,0,2,3,0,4,5,0]
Output: [1,0,0,2,3,0,0,4]
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]

Example 2:
Input: arr = [1,2,3]
Output: [1,2,3]
Explanation: After calling your function, the input array is modified to: [1,2,3]

Constraints:
1 <= arr.length <= 104
0 <= arr[i] <= 9
*/
