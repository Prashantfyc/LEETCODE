class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0, high = arr.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Index mid tak kitne numbers missing hain
            int missing = arr[mid] - (mid + 1);
            
            if (missing < k) {
                low = mid + 1; // Right half me search karo
            } else {
                high = mid - 1; // Left half me search karo
            }
        }
        
        // Binary search ke baad formula lagao
        return low + k;
    }
}