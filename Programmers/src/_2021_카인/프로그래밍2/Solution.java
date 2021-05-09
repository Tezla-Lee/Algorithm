package _2021_카인.프로그래밍2;

// P: 응시자, O: 빈 테이블, X: 파티션
class Solution {
    private final int[] dr = {1, -1, 0, 0};
    private final int[] dc = {0, 0, 1, -1};
    private boolean[][] isVisited;
    private char[][] place;

    public int[] solution(String[][] places) {
        int[] check = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            place = convertPlace(places[i]);
            check[i] = checkPlace();
        }

        return check;
    }

    // String[]을 char[][] 형태로 변환
    char[][] convertPlace(String[] place) {
        char[][] result = new char[5][5];

        for (int i = 0; i < 5; i++) {
            System.arraycopy(place[i].toCharArray(), 0, result[i], 0, 5);
        }

        return result;
    }

    // 대기실의 자리들이 올바르게 배치되었나 확인
    int checkPlace() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i][j] == 'P') {
                    isVisited = new boolean[5][5];
                    isVisited[i][j] = true;
                    if (!checkSeat(i, j, 0)) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    // 각 자리가 올바른 거리두기 인지 확인
    boolean checkSeat(int row, int col, int depth) {
        if (depth == 2) {
            return true;
        }

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dr[i];
            int nextCol = col + dc[i];

            if (nextRow >= 0 && nextCol >= 0 && nextRow < 5 && nextCol < 5 && !isVisited[nextRow][nextCol]) {
                if (place[nextRow][nextCol] == 'P') {
                    return false;
                } else if (place[nextRow][nextCol] == 'O') {
                    isVisited[nextRow][nextCol] = true;
                    if (!checkSeat(nextRow, nextCol, depth + 1)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution().solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
//                {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}})));
//    }
}