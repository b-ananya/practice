class Solution {

    private Map<Integer, Set<Integer>> map = new HashMap<>();
    private int[] indegree;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        indegree = new int[numCourses];
        int[] res = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            map.put(i, new HashSet<>());
        }

        for (int[] c : prerequisites) {
            map.get(c[1]).add(c[0]);
            indegree[c[0]]++;
            // map 1:2,3,4 means course 1 unlocks 2,3,4
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
            
        int done = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            res[done++] = node;

            for (int neighbor: map.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        if (done != numCourses) {
            return new int[0];
        }

        return res;
        
    }
}
