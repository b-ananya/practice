class Solution {
    public int minGroups(int[][] intervals) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] interval : intervals) {
            if (!minHeap.isEmpty() && minHeap.peek() < interval[0]) {
                minHeap.poll();
            }
            minHeap.offer(interval[1]);
        }

        return minHeap.size();

    }
}
