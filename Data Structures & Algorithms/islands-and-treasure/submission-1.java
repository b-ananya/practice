class Solution {
    private int INF = 2147483647;
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    queue.add(new int[] {r, c});
                }
            }
        }

        if (queue.size() == 0) {
            return;
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];

            for (int[] dir : directions) {
                int r = row + dir[0];
                int c = col + dir[1];

                if (r >= grid.length || c >= grid[0].length || r < 0 || c < 0 || grid[r][c] != INF) {
                    continue;
                }
                queue.add(new int[] {r, c});
                grid[r][c] = grid[row][col] + 1;
            }
        }
    }
}
