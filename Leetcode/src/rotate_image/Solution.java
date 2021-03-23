package rotate_image;

class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] rotatedMatrix = new int[n][n];

        // 한 행씩 끝에 열부터 채워 넣는다
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotatedMatrix[j][n - 1 - i] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            System.arraycopy(rotatedMatrix[i], 0, matrix[i], 0, n);
        }
    }
}