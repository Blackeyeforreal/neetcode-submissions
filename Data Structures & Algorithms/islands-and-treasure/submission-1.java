
class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0) return;

        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int INF = 2147483647; // Represents empty land

        // Step 1: Add all treasures (0) to the queue first
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 0) {
                    queue.offer(new int[] {row, col});
                }
            }
        }

        // Direction vectors for moving: Down, Right, Up, Left
        int[][] ways = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        // Step 2: Multi-source BFS
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];

            for (int[] way : ways) {
                int i = r + way[0];
                int j = c + way[1];

                // Check boundaries and ensure it is unvisited land (INF)
                if (i >= 0 && j >= 0 && i < n && j < m && grid[i][j] == INF) {
                    // Update land with the distance from the treasure
                    grid[i][j] = grid[r][c] + 1;
                    queue.offer(new int[] {i, j});
                }
            }
        }
        // The problem modifies the grid in-place, so no return statement is needed
    }
}
