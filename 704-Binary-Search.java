class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int target, int left, int right) {

        // Base case
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        // Target found
        if (nums[mid] == target) {
            return mid;
        }

        // Search right half
        if (target > nums[mid]) {
            return binarySearch(nums, target, mid + 1, right);
        }

        // Search left half
        return binarySearch(nums, target, left, mid - 1);
    }
}