class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        Arrays.sort(nums);

        recursion(ans, current, nums, 0);

        return ans;
    }

    void recursion(
        List<List<Integer>> ans,
        List<Integer> current,
        int[] nums,
        int index
    ) {

        ans.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {

            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            current.add(nums[i]);

            recursion(ans, current, nums, i + 1);

            current.remove(current.size() - 1);
        }
    }
}