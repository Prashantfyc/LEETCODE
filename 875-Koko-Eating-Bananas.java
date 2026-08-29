class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 1;

        // Find biggest pile
        for (int pile : piles) {
            if (pile > high) {
                high = pile;
            }
        }

        while (low < high) {

            int k = low + (high - low) / 2;

            int hours = 0;

            for (int pile : piles) {
                hours += (pile + k - 1) / k;
            }

            if (hours > h) {
                low = k + 1;
            } else {
                high = k;
            }
        }

        return low;
    }
}