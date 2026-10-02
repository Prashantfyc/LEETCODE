class Solution {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(nums, 0, current, result);

        return result;
    }

    public void backtrack(
        int[] nums,
        int index,
        List<Integer> current,
        List<List<Integer>> result
    ) {

        // Current subset ko answer mein daalo
        result.add(new ArrayList<>(current));

        // Har element ke liye choice
        for (int i = index; i < nums.length; i++) {

            // TAKE
            current.add(nums[i]);

            // RECURSE
            backtrack(nums, i + 1, current, result);

            // UNDO
            current.remove(current.size() - 1);
        }
    }
}