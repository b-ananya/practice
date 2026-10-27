class Solution {
    public int subarraySum(int[] nums, int k) {

        // in the prefix array: how many earlier spots have prefix sum = curprefixsum - k

        int res = 0;
        int curSum = 0;

        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);

        for (int num : nums) {
            curSum += num;

            int dif = curSum - k;
            res += prefixSums.getOrDefault(dif, 0);
            prefixSums.put(curSum, prefixSums.getOrDefault(curSum, 0) + 1);

        }

        return res;

    }
}