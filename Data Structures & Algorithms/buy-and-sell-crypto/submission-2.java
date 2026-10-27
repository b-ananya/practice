class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int minSoFar = prices[0];

        for (int i = 0; i < prices.length; i++) {
            maxP = Math.max(maxP, prices[i] - minSoFar);
            minSoFar = Math.min(minSoFar, prices[i]);
        }

        return maxP;
    }
}
