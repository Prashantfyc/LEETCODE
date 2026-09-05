class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {

        // 1. Search the smaller array
        if (a.length > b.length)
            return findMedianSortedArrays(b, a);

        int m = a.length;
        int n = b.length;

        int low = 0;
        int high = m;

        // 2. Total elements that must be on LEFT
        int half = (m + n + 1) / 2;

        while (low <= high) {

            // 3. Make the cuts
            int cutA = low + (high - low) / 2;
            int cutB = half - cutA;

            int leftA  = (cutA == 0) ? Integer.MIN_VALUE : a[cutA - 1];
            int rightA = (cutA == m) ? Integer.MAX_VALUE : a[cutA];

            int leftB  = (cutB == 0) ? Integer.MIN_VALUE : b[cutB - 1];
            int rightB = (cutB == n) ? Integer.MAX_VALUE : b[cutB];

            // 4. Is the cut correct?
            if (leftA <= rightB && leftB <= rightA) {

                // Odd
                if ((m + n) % 2 == 1)
                    return Math.max(leftA, leftB);

                // Even
                return (Math.max(leftA, leftB)
                      + Math.min(rightA, rightB)) / 2.0;
            }

            // Cut A is too far RIGHT
            if (leftA > rightB)
                high = cutA - 1;

            // Cut A is too far LEFT
            else
                low = cutA + 1;
        }

        return 0.0;
    }
}