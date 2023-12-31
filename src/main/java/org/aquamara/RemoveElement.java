package org.aquamara;

// Remove Element
// 14/8/2023
// https://leetcode.com/explore/learn/card/fun-with-arrays/526/deleting-items-from-an-array/3247/
public class RemoveElement {

    public static void main(String[] args) {
        int i1 = removeElement(new int[]{3, 2, 2, 3}, 3);
        int i2 = removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
    }

    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != val)
                nums[index++] = nums[i];
        }
        return index;
    }

    // not tested
    public static int removeElement2(int[] nums, int val) {
        int s = 0;
        int e = nums.length-1;
        while(s<=e){
            if(nums[e] == val){
                e--;
            }
            else{
                if(nums[s] == val){
                    int temp = nums[e];
                    nums[e] = nums[s];
                    nums[s] = temp;
                    s++;
                    e--;
                }
                else{
                    s++;
                }
            }
        }
        return e+1;
    }
}

/*
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
The remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:
The judge will test your solution with the following code:
int[] nums = [...]; // Input array
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length.
                            // It is sorted with no values equaling val.
int k = removeElement(nums, val); // Calls your implementation
assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i < actualLength; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

Example 1:
Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).

Example 2:
Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).

Constraints:
0 <= nums.length <= 100
0 <= nums[i] <= 50
0 <= val <= 100
 */
