class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        recursion(candidates, target, ans, current, 0, 0);

        return ans;
    }

    void recursion(
        int[] candidates,
        int target,
        List<List<Integer>> ans,
        List<Integer> current,
        int sum,
        int index
    ) {

        if (sum == target) {
            ans.add(new ArrayList<>(current));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            // Choose
            current.add(candidates[i]);

            // Recurse
            recursion(
                candidates,
                target,
                ans,
                current,
                sum + candidates[i],
                i
            );

            // Undo
            current.remove(current.size() - 1);
        }
    }
}