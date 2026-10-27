class Solution {
    public int subarraySum(int[] nums, int k) {

        // prefix[i] - prefix[j] = k -> prefix[i] = k + prefix[j]

        // map: sum -> frequency
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int res = 0;
        int curSum = 0;

        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            int dif = curSum - k;

            if (map.containsKey(dif)) {
                res += map.get(dif);
            }

            if (map.containsKey(curSum)) {
                map.put(curSum, map.get(curSum) + 1);
            } else {
                map.put(curSum, 1);
            }
        }

        return res;
        
    }
}