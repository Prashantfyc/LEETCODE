class Solution {
    public int myAtoi(String s) {

        int i = 0;

        // 1. Skip spaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Sign
        int sign = 1;

        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        else if (s.charAt(i) == '+') {
            i++;
        }

        // 3. Build number
        int num = 0;

        while (i < s.length() &&
               s.charAt(i) >= '0' &&
               s.charAt(i) <= '9') {

            int digit = s.charAt(i) - '0';

            num = num * 10 + digit;

            i++;
        }

        return num * sign;
    }
}