/*Find First and Last Position of Element in Sorted Array
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

Follow up: Could you write an algorithm with O(log n) runtime complexity?

 

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = binarySearch(nums,target,0);
        if(leftIndex == nums.length || nums[leftIndex] != target) return new int[]{-1,-1};
        return new int[]{leftIndex,binarySearch(nums,target + 1,leftIndex) - 1};
    }
    private int binarySearch(int nums[], int t, int left){
        int mid = 0,right = nums.length - 1;
        while(left <= right){
            mid = left + (right - left) / 2;
            if(nums[mid] < t)
                left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}