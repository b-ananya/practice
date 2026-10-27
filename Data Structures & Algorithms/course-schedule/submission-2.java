class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        Queue<Integer> queue = new PriorityQueue<>();
        int[] prereqs = new int[numCourses];

        for (int[] course: prerequisites) {
            map.get(course[0]).add(course[1]);
            prereqs[course[1]]++;
        }

        for (int j = 0; j < numCourses; j++) {
            if (prereqs[j] == 0) {
                queue.add(j);
            }
        }

        int finished = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            finished++;

            for (int neighbor : map.get(course)) {
                prereqs[neighbor]--;
                if (prereqs[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return finished == numCourses;
        
    }
}
