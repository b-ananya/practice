class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int[] res = new int[tasks.length];
        
        // (ts done at, index)
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        
        // (weight, index)
        PriorityQueue<int[]> idle = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        
        for (int i = 0; i < servers.length; i++) {
            idle.offer(new int[] {servers[i], i});
        }
        
        long ts = 0;
        for (int i = 0; i < tasks.length; i++) {
            ts = Math.max(ts, i);
            release(busy, idle, servers, ts);
            
            if (idle.isEmpty()) {
                ts = busy.peek()[0];
                release(busy, idle, servers, ts);
            }
            
            int[] server = idle.poll();
            int index = server[1];
            res[i] = index;
            busy.offer(new long[] {ts + tasks[i], index});
        }
        return res;
    }
    
    public void release(PriorityQueue<long[]> busy, PriorityQueue<int[]> idle, int[] servers, long ts) {
        while (!busy.isEmpty() && busy.peek()[0] <= ts) {
            long[] server = busy.poll();
            int index = (int) server[1];
            idle.offer(new int[] {servers[index], index});
        }
    }
}
