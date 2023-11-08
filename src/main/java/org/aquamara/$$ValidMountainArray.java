package org.aquamara;

// Valid Mountain Array
// 17/8/2023
// https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3251/
public class $$ValidMountainArray {

    public static void main(String[] args) {
        boolean b3 = validMountainArray(new int[]{0,3,2,1});    // true
        boolean b00 = validMountainArray(new int[]{1,0,3,4,5}); // false
        boolean b01 = validMountainArray(new int[]{0,3,4,5});   // false
        boolean b02 = validMountainArray(new int[]{10,3,2,1});  // false
        boolean b0 = validMountainArray(new int[]{0,3,2,1,5,8});    // false
        boolean b1 = validMountainArray(new int[]{2,1});    // false
        boolean b2 = validMountainArray(new int[]{3,5,5});  // false
    }

    public static boolean validMountainArray(int[] arr) {
        int length = arr.length;
        if (length < 3)
            return false;
        int index = 0;
        while (index < length - 1 && arr[index] < arr[index + 1]) {
            ++index;
        }

        if (index == length - 1 || index == 0)
            return false;

        while (index < length - 1 && arr[index] > arr[index + 1]) {
            ++index;
        }

        return index == length - 1;
    }

    public static boolean validMountainArray4(int[] arr) {
        int length = arr.length;
        if (length < 3)
            return false;
        int bottomIndex = 0, topIndex = length - 1;
        while (bottomIndex < length - 1 && arr[bottomIndex] < arr[bottomIndex + 1]) {
            ++bottomIndex;
        }
        while (topIndex > 0 && arr[topIndex] < arr[topIndex - 1]) {
            --topIndex;
        }

        return topIndex == bottomIndex && topIndex != length - 1 && bottomIndex != 0;
    }

    public static boolean validMountainArray3(int[] arr) {
        int length = arr.length;
        if (length < 3)
            return false;
        int index = 0;
        boolean goesBottom = false;
        while (index < length - 1 && arr[index] < arr[index + 1]) {
            ++index;
        }
        if (index == length - 1 || index == 0)
            return false;
        while (index < length - 1 && arr[index] > arr[index + 1]) {
            ++index;
            goesBottom = true;
        }
        return goesBottom && index == length - 1;
    }

    public static boolean validMountainArray2(int[] arr) {
        int length = arr.length;
        if (length < 3)
            return false;
        int index = 0;
        boolean goesTop = false, goesBottom = false;
        while (index < length - 1 && arr[index] < arr[index + 1]) {
            ++index;
            goesTop = true;
        }
        if (!goesTop)
            return false;
        while (index < length - 1 && arr[index] > arr[index + 1]) {
            ++index;
            goesBottom = true;
        }
        if (!goesBottom || index != length - 1)
            return false;
        else
            return true;
    }

    public static boolean validMountainArray11(int[] arr) {
        int length = arr.length;
        if (length < 3)
            return false;
        boolean goesTop = false;
        boolean goesBottom = false;
        if (arr[0] > arr[1])
            return false;
        for (int i = 0; i < length - 1; i++) {
            if (arr[i + 1] > arr[i] && !goesBottom && !goesTop)
                goesTop = true;
            if (arr[i] == arr[i + 1])
                return false;
            if (arr[i + 1] < arr[i] && goesTop) {
                goesTop = false;
                goesBottom = true;
            }
            if (arr[i + 1] > arr[i] && goesBottom)
                return false;
        }
        return goesBottom && !goesTop;  //goesBottom
    }
}

/*
Given an array of integers arr, return true if and only if it is a valid mountain array.
Recall that arr is a mountain array if and only if:
arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Example 1:
Input: arr = [2,1]
Output: false

Example 2:
Input: arr = [3,5,5]
Output: false

Example 3:
Input: arr = [0,3,2,1]
Output: true

Constraints:
1 <= arr.length <= 104
0 <= arr[i] <= 104
*/
