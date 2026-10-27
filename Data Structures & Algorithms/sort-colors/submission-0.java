class Solution {
    public void sortColors(int[] nums) {
        // counting sort: count how many of each in one pass
        // manually add that amount of each on a second pass


        // O(n), l and r are boundaries -> 1 naturally in the middle
        int i = 0, l = 0, r = nums.length - 1;

        while (i <= r) {
            if (nums[i] == 0) {
                swap(nums, l, i);
                l++;
            } else if (nums[i] == 2) {
                swap(nums, i, r);
                r--;
                i--;
            }
            i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}