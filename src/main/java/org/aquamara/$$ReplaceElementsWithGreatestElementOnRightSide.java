package org.aquamara;

// Replace Elements with Greatest Element on Right Side
// 17/8/2023
// https://leetcode.com/explore/learn/card/fun-with-arrays/511/in-place-operations/3259/
public class $$ReplaceElementsWithGreatestElementOnRightSide {

    public static void main(String[] args) {
        //int[] ints0 = replaceElements(new int[]{17, 18, 5, 4, 6, 1});
        int[] ints1 = replaceElements(new int[]{400});
    }

    public static int[] replaceElements(int[] arr) {
        int length = arr.length;
        int max = arr[length - 1], prevValue = 0;

        // length - 2 as we don't need to look at the last element, it will be -1 and its value is already max
        for (int i = length - 2; i >= 0; i--) {
            prevValue = arr[i];
            arr[i] = max;
            max = Math.max(prevValue, max);
        }

        arr[length - 1] = -1;

        return arr;
    }

    public static int[] replaceElements1(int[] arr) {
        int length = arr.length;
        int maxValue = arr[length - 1];
        int prevMax = 0;

        for (int i = length - 1; i > 0; i--) {
            if (arr[i - 1] > maxValue) {
                prevMax = maxValue;
                maxValue = arr[i - 1];
                arr[i - 1] = prevMax;
            } else
                arr[i - 1] = maxValue;
        }

        arr[length - 1] = -1;

        return arr;
    }
}

/*
Given an array arr, replace every element in that array with the greatest element among the elements to its right,
and replace the last element with -1.
After doing so, return the array.

Example 1:
Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
Explanation:
- index 0 --> the greatest element to the right of index 0 is index 1 (18).
- index 1 --> the greatest element to the right of index 1 is index 4 (6).
- index 2 --> the greatest element to the right of index 2 is index 4 (6).
- index 3 --> the greatest element to the right of index 3 is index 4 (6).
- index 4 --> the greatest element to the right of index 4 is index 5 (1).
- index 5 --> there are no elements to the right of index 5, so we put -1.

Example 2:
Input: arr = [400]
Output: [-1]
Explanation: There are no elements to the right of index 0.

Constraints:
1 <= arr.length <= 104
1 <= arr[i] <= 105
*/
