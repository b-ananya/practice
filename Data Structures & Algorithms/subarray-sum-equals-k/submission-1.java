class Solution {
    public int subarraySum(int[] nums, int k) {

        // Input: nums = [2,-1,1,2], k = 2
        // Output: 4
        // Input: nums = [4,4,4,4,4,4], k = 4
        // Output: 6


        // for each position, we want to count how many earlier positions have a prefix sum equal to currentPrefixSum - k. A hash map lets us track prefix sum frequencies as we iterate, giving O(1) lookups
        int res = 0;
        int curSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {

            curSum += num;

            int dif = curSum - k;
            res += map.getOrDefault(dif, 0);
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);

        }
        return res;
    }
}