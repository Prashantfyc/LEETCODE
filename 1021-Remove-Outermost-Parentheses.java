class Solution {
    public String removeOuterParentheses(String s) {

        StringBuilder ans = new StringBuilder();
        int counter = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                counter++;

                if (counter > 1) {
                    ans.append(ch);
                }
            }

            else {
                counter--;

                if (counter > 0) {
                    ans.append(ch);
                }
            }
        }

        return ans.toString();
    }
}