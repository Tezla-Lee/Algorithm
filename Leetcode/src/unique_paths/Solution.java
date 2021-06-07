package unique_paths;

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] counts = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == 1 && j == 1) {
                    counts[i][j] = 1;
                    continue;
                }
                counts[i][j] = counts[i - 1][j] + counts[i][j - 1];
            }
        }

        return counts[m][n];
    }
}