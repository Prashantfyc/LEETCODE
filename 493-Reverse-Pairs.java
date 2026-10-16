class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int low, int high) {
        if (low >= high) return 0;

        int mid = (low + high) / 2;
        int count = mergeSort(nums, low, mid) + mergeSort(nums, mid + 1, high);

        // count pairs across two halves
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && (long)nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        // merge step
        merge(nums, low, mid, high);
        return count;
    }

    private void merge(int[] nums, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int i = low, j = mid + 1;

        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) temp.add(nums[i++]);
            else temp.add(nums[j++]);
        }

        while (i <= mid) temp.add(nums[i++]);
        while (j <= high) temp.add(nums[j++]);

        for (int k = 0; k < temp.size(); k++) {
            nums[low + k] = temp.get(k);
        }
    }
}
