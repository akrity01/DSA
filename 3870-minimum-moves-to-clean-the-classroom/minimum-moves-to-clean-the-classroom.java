import java.util.*;

class Solution {

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        // Step 1: Find starting position and number every litter
        int sr = 0, sc = 0;
        int litterCount = 0;

        int[][] litterId = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(litterId[i], -1);

            for (int j = 0; j < n; j++) {

                char ch = classroom[i].charAt(j);

                if (ch == 'S') {
                    sr = i;
                    sc = j;
                }

                if (ch == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        // All litter collected mask
        int targetMask = (1 << litterCount) - 1;

        // State = {row, col, remainingEnergy, mask, moves}
        Queue<int[]> queue = new LinkedList<>();

        // visited[row][col][energy][mask]
        boolean[][][][] visited =
                new boolean[m][n][energy + 1][1 << litterCount];

        // Starting state
        queue.offer(new int[]{sr, sc, energy, 0, 0});
        visited[sr][sc][energy][0] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();

            int r = curr[0];
            int c = curr[1];
            int currEnergy = curr[2];
            int mask = curr[3];
            int moves = curr[4];

            // All litter collected
            if (mask == targetMask) {
                return moves;
            }

            // If no energy and we are not on R,
            // we cannot make another move.
            if (currEnergy == 0) {
                continue;
            }

            // Try 4 directions
            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                // Outside grid
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                // Obstacle
                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                // Spend one energy
                int newEnergy = currEnergy - 1;

                // Collect litter if present
                int newMask = mask;

                if (classroom[nr].charAt(nc) == 'L') {
                    int id = litterId[nr][nc];
                    newMask = mask | (1 << id);
                }

                // Reset energy on R
                if (classroom[nr].charAt(nc) == 'R') {
                    newEnergy = energy;
                }

                // Avoid repeated states
                if (!visited[nr][nc][newEnergy][newMask]) {

                    visited[nr][nc][newEnergy][newMask] = true;

                    queue.offer(new int[]{
                        nr,
                        nc,
                        newEnergy,
                        newMask,
                        moves + 1
                    });
                }
            }
        }

        return -1;
    }
}