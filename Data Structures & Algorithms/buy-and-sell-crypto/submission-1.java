class Solution {
    public int maxProfit(int[] prices) {
        // find the max num to the left of the smallest num

        // two pointer
        // int left = 0;
        // int right = 1;
        // int max = 0;
        // while (right < prices.length) {
        //     if (prices[left] < prices[right]) {
        //         max = Math.max(max, prices[right] - prices[left]);
        //     } else {
        //         left = right;
        //     }
        //     right++;
        // }
        // return max;



        // dynamic programming
        // track of lowest price til now
        // track of max profit til now

        int lowP = prices[0];
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - lowP);
            if (prices[i] < lowP) {
                lowP = prices[i];
            }
        }

        return max;

    }
}
