class Solution {
    class Orange {
        int row;
        int col;
        int time;

        Orange(int r, int c, int t) {
            row = r;
            col = c;
            time = t;
        }
    }

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] visited = new int[rows][cols];
        Queue<Orange> queue = new LinkedList<>();

        int freshOrangesCount = 0;

        // Initialize the queue with rotten oranges and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    freshOrangesCount++;
                } else if (grid[i][j] == 2) {
                    queue.add(new Orange(i, j, 0));
                    visited[i][j] = 2;
                }
            }
        }

        int maxTime = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int rottenOrangesCount = 0;

        while (!queue.isEmpty()) {
            Orange currentOrange = queue.poll();
            int currentRow = currentOrange.row;
            int currentCol = currentOrange.col;
            int currentTime = currentOrange.time;
            maxTime = Math.max(currentTime, maxTime);

            // Explore neighboring oranges
            for (int[] dir : directions) {
                int newRow = currentRow + dir[0];
                int newCol = currentCol + dir[1];

                // Check if the neighbor is within bounds and is a fresh orange
                if (newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols &&
                    visited[newRow][newCol] == 0 && grid[newRow][newCol] == 1) {
                    visited[newRow][newCol] = 2;
                    queue.add(new Orange(newRow, newCol, currentTime + 1));
                    rottenOrangesCount++;
                }
            }
        }

        // Check if all fresh oranges were reached
        if (rottenOrangesCount == freshOrangesCount) {
            return maxTime;
        }

        // Some fresh oranges couldn't be reached
        return -1;
    }
}
