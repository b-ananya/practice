class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;

        int left = 0;
        int right = heights.length - 1;

        while (right > left) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(heights[left], heights[right]));

            if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }
        }

        return maxArea;
    }
}
