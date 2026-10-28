class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {

        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int s = edge.get(0);
            int d = edge.get(1);
            int w = edge.get(2);

            adj.get(s).add(new int[]{d, w});
        }

        Map<Integer, Integer> map = new HashMap<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minHeap.offer(new int[]{0, src});

        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int w1 = cur[0];
            int n1 = cur[1];

            if (map.containsKey(n1)) {
                continue;
            }

            map.put(n1, w1);

            for (int[] edge : adj.get(n1)) {
                int n2 = edge[0];
                int w2 = edge[1];
                if(!map.containsKey(n2)) {
                    minHeap.offer(new int[]{w2 + w1, n2});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            map.putIfAbsent(i, -1);
        }

        return map;


    }  
}
