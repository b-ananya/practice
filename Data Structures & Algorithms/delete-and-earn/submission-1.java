class Solution {
    public int deleteAndEarn(int[] nums) {

        int[] points = new int[10001];
        for (int x : nums) points[x] += x;
        int prev = 0, best = 0;
        for (int score : points) {
            int next = Math.max(best, prev + score);
            prev = best; best = next;
        }
        return best;
    }
}
