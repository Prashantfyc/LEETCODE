/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        int peak = peakIndexInMountainArray(arr);

        // First, try to search in the ascending part
        int firstTry = orderAgnosticBS(arr, target, 0, peak);
        if (firstTry != -1) {
            return firstTry;
        }

        // If not found, search in descending part
        return orderAgnosticBS(arr, target, peak + 1, arr.length() - 1);
    }

    // Step 1: Find peak index in mountain array
    private int peakIndexInMountainArray(MountainArray arr) {
        int start = 0;
        int end = arr.length() - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr.get(mid) > arr.get(mid + 1)) {
                end = mid;  // we are in descending part
            } else {
                start = mid + 1; // we are in ascending part
            }
        }
        return start; // or end (both point to peak)
    }

    // Step 2: Order-agnostic binary search
    private int orderAgnosticBS(MountainArray arr, int target, int start, int end) {
        boolean isAsc = arr.get(start) < arr.get(end);

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int value = arr.get(mid);

            if (value == target) {
                return mid;
            }

            if (isAsc) {
                if (target < value) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > value) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}