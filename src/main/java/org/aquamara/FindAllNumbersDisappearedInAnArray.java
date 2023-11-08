package org.aquamara;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Find All Numbers Disappeared in an Array
// 28/8/2023
// https://leetcode.com/explore/learn/card/fun-with-arrays/523/conclusion/3270/
public class FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        List<Integer> disappearedNumbers0 = findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        List<Integer> disappearedNumbers1 = findDisappearedNumbers(new int[]{1, 1});
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        int[] numberDistribution = new int[nums.length + 1];
        List<Integer> disappearedNumbers = new ArrayList<>();

        for (int num : nums)
            ++numberDistribution[num];

        for (int i = 1; i < numberDistribution.length; i++) {
            if (numberDistribution[i] == 0)
                disappearedNumbers.add(i);
        }

        return disappearedNumbers;
    }

    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> disappearedNumbers = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap();
        int topBorder = nums.length;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 0);
        }
        for (int i = 1; i <= topBorder; i++) {
            if (map.get(i) == null)
                disappearedNumbers.add(i);
        }

        return disappearedNumbers;
    }
}

/*
Given an array nums of n integers where nums[i] is in the range [1, n],
return an array of all the integers in the range [1, n] that do not appear in nums.

Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]

Example 2:
Input: nums = [1,1]
Output: [2]

Constraints:
n == nums.length
1 <= n <= 105
1 <= nums[i] <= n

Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
*/
