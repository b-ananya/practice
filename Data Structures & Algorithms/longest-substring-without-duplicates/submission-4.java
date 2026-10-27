class Solution {
    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        int left = 0;
        // map holds last known index (val) of a value (key)
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                // determine need to jump forward or not
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            map.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
        }

        return max;
        
    }
}
