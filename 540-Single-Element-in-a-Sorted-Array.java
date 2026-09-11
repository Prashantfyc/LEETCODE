class Solution {
    public int singleNonDuplicate(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            // Make mid even
            if (mid % 2 == 1) {
                mid--;
            }

            // Correct pair
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            }

            // Pair broken
            else {
                high = mid;
            }
        }

        return nums[low];
    }
}