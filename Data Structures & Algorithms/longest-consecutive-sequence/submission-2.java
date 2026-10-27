class Solution {
    public int longestConsecutive(int[] nums) {

        // stores lengths at boundary positions
        Map<Integer, Integer> map = new HashMap<>();

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }

            int length = map.getOrDefault(nums[i] - 1, 0) + map.getOrDefault(nums[i] + 1, 0) + 1;
            map.put(nums[i], length);

            map.put(nums[i] - map.getOrDefault(nums[i] - 1, 0), length);
            map.put(nums[i] + map.getOrDefault(nums[i] + 1, 0), length);

            if (map.get(nums[i]) > res) {
                res = length;
            }
        }

        return res;

        
    }
}
