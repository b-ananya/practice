class Solution {
    public int characterReplacement(String s, int k) {

        Map<Character, Integer> count = new HashMap<>();

        int left = 0;

        int maxLength = 0;
        int maxFreq = 0;

        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, count.get(s.charAt(r)));

            while ((r - left + 1) - maxFreq > k) {
                count.put(s.charAt(left),
                count.get(s.charAt(left)) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, r - left + 1);
        }

        return maxLength;


        // increase window til k different
        // update max substring length
        // as you move left, move right til k different

        
    }
}
