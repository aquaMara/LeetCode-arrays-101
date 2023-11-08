package org.aquamara;

// Find Numbers with Even Number of Digits
// 11/8/2023
// https://leetcode.com/explore/learn/card/fun-with-arrays/521/introduction/3237/
public class FindNumbersWithEvenNumberOfDigits {

    public static void main(String[] args) {
        int x = 1 / 10;
        int qx = 1 % 10;
        System.out.println(findNumbers(new int[]{12,345,2,6,7896}));
        System.out.println(findNumbers(new int[]{555,901,482,1771}));
    }

    public static int findNumbers3(int[] nums) {
        int countEven = 0;
        for (int num : nums) {
            if (((int) Math.log10(num) + 1) % 2 == 0)
                ++countEven;
        }
        return countEven;
    }

    public static int findNumbers(int[] nums) {
        int evenCount = 0;
        int digitsCount = 0;

        for (int num : nums) {
            while (num != 0){
                num /= 10;
                ++digitsCount;
            }
            if (digitsCount % 2 == 0)
                ++evenCount;
            digitsCount = 0;
        }

        return evenCount;
    }

    public static int findNumbers1(int[] nums) {
        int evenCount = 0;
        int digitsCount = 1;

        for (int num : nums) {
            while (num / 10 != 0){
                num /= 10;
                ++digitsCount;
            }
            if (digitsCount % 2 == 0)
                ++evenCount;
            digitsCount = 1;
        }

        return evenCount;
    }
}

/*
Given an array nums of integers, return how many of them contain an even number of digits.

Example 1:
Input: nums = [12,345,2,6,7896]
Output: 2
Explanation:
12 contains 2 digits (even number of digits).
345 contains 3 digits (odd number of digits).
2 contains 1 digit (odd number of digits).
6 contains 1 digit (odd number of digits).
7896 contains 4 digits (even number of digits).
Therefore, only 12 and 7896 contain an even number of digits.

Example 2:
Input: nums = [555,901,482,1771]
Output: 1
Explanation:
Only 1771 contains an even number of digits.
 */
