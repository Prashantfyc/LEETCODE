class Solution {
    public int singleNonDuplicate(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            // Pair ki starting position even honi chahiye
            if (mid % 2 == 1) {
                mid--;
            }

            // Proper pair → single RIGHT
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            }

            // Pair broken → single LEFT or mid
            else {
                high = mid;
            }
        }

        return nums[low];
    }
}