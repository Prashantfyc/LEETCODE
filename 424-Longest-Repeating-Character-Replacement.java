class Solution {
    public int characterReplacement(String s, int k) {

        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        int[] count = new int[26];

        for (int right = 0; right < s.length(); right++) {

            int index = s.charAt(right) - 'A';
            count[index]++;

            if (count[index] > maxFreq) {
                maxFreq = count[index];
            }

            while ((right - left + 1) - maxFreq > k) {

                int leftIndex = s.charAt(left) - 'A';
                count[leftIndex]--;

                left++;
            }

            int length = right - left + 1;

            if (length > maxLength) {
                maxLength = length;
            }
        }

        return maxLength;
    }
}