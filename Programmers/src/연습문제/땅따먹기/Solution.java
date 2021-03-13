package 연습문제.땅따먹기;

class Solution {
    int solution(int[][] land) {
        int answer = 0;

        for (int i = 1; i < land.length; i++) {
            int[] temp = land[i].clone();
            for (int j = 0; j < land[0].length; j++) {
                for (int k = 0; k < land[0].length; k++) {
                    if (j == k) {
                        continue;
                    }
                    if (land[i][j] < temp[j] + land[i - 1][k]) {
                        land[i][j] = temp[j] + land[i - 1][k];
                    }
                }
            }
        }

        for (int i = 0; i < land.length; i++) {
            answer = Math.max(answer, land[land.length - 1][i]);
        }
        return answer;
    }
}