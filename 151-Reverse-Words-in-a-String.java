class Solution {
    public String reverseWords(String s) {

        // Remove extra spaces and get individual words
        String[] words = s.trim().split("\\s+");

        // Store the final answer
        StringBuilder ans = new StringBuilder();

        // Start from the last word
        for (int i = words.length - 1; i >= 0; i--) {

            // Add the current word
            ans.append(words[i]);

            // Add space between words
            if (i > 0) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }
}
