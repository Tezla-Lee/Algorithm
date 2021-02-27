package _2020_카카오블라인드채용.기둥과보설치;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    // [x, y, a, b]
    // a : 0 기둥 1 보
    // b : 0 삭제 1 설치
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        int[][] board = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(board[i], -1);
        }

        List<int[]> list = new ArrayList<>();
        for (int[] arr : build_frame) {
//            if (arr[3] == 1) {
//                list.add(new int[]{arr[0], arr[1], arr[2]});
            board[arr[0]][arr[1]] = arr[2];
//            } else {
//                list.remove(new int[]{arr[0], arr[1], arr[2]});
//            }
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    if (o1[1] == o2[1]) {
                        return o1[2] - o2[2];
                    }
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        for (int[] arr : list) {
            System.out.print(Arrays.toString(arr) + " ");
        }

        return answer;
    }

    public static void main(String[] args) {
        new Solution().solution(5, new int[][]{{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}});
        System.out.println();
        new Solution().solution(5, new int[][]{{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}});
    }
}