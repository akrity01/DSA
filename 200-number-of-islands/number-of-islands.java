import java.util.*;

class Solution {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    dfs(grid, visited, i, j, n, m);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, boolean[][] visited, int i, int j, int n, int m) {

        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newRow = i + dx[k];
            int newCol = j + dy[k];

            if (isValid(newRow, newCol, n, m) &&
                grid[newRow][newCol] == '1' &&
                !visited[newRow][newCol]) {

                dfs(grid, visited, newRow, newCol, n, m);
            }
        }
    }

    public boolean isValid(int i, int j, int n, int m) {
        return (i >= 0 && j >= 0 && i < n && j < m);
    }
}