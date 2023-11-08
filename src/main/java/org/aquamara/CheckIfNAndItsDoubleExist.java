package org.aquamara;

import java.util.HashMap;
import java.util.Map;

// Check If N and Its Double Exist
// 14/8/2023
// https://leetcode.com/explore/learn/card/fun-with-arrays/527/searching-for-items-in-an-array/3250/
public class CheckIfNAndItsDoubleExist {

    public static void main(String[] args) {
        boolean b1 = checkIfExist(new int[]{7,1,14,11});
        boolean b = checkIfExist(new int[]{10,2,5,3});
        boolean bb = checkIfExist(new int[]{3,1,7,11});
    }

    public static boolean checkIfExist(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j && arr[i] == 2 * arr[j])
                    return true;
            }
        }
        return false;
    }

    public static boolean checkIfExist2(int[] arr) {
        int length = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(arr[i], i);
            if (map.containsKey(arr[i] * 2) && map.get(arr[i] * 2) != i)
                return true;
        }
        for (int i = 0; i < length; i++) {
            if (map.containsKey(arr[i] * 2) && map.get(arr[i] * 2) != i)
                return true;
        }
        return false;
    }
}

/*
Given an array arr of integers, check if there exist two indices i and j such that :
i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]

Example 1:
Input: arr = [10,2,5,3]
Output: true
Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]

Example 2:
Input: arr = [3,1,7,11]
Output: false
Explanation: There is no i and j that satisfy the conditions.

Constraints:
2 <= arr.length <= 500
-103 <= arr[i] <= 103
 */
