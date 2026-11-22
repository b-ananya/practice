class Solution {
    public int minGroups(int[][] intervals) {

        // PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // for (int[] interval : intervals) {
        //     if (!minHeap.isEmpty() && minHeap.peek() < interval[0]) {
        //         minHeap.poll();
        //     }
        //     minHeap.offer(interval[1]);
        // }

        // return minHeap.size();

        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int j = 0;
        int answer = 0;
        for (int i = 0; i < intervals.length; i++) {
            while(ends[j] < starts[i]) j++;
            answer = Math.max(answer, i - j + 1);
        }
        return answer;

    }
}
