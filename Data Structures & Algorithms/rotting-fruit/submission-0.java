class Solution {

    public int orangesRotting(int[][] grid) {
        // fill in distances from the closest orange
        // return max steps as time 

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 2) {
                    queue.add(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int min = 0;
        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int row = cur[0];
                int col = cur[1];

                for (int[] dir : directions) {
                    int r = row + dir[0];
                    int c = col + dir[1];

                    if (r >= grid.length || r < 0 || c >= grid[0].length || c < 0 || grid[r][c] != 1) {
                        continue;
                    }
                    grid[r][c] = 2;
                    fresh--;
                    queue.add(new int[]{r, c});
                }
            }

            min++;

            
        }

        if (fresh != 0) {
            return -1;
        }
        
        return min;
    }
}
