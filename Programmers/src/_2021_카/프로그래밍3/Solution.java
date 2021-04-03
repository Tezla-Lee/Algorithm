package _2021_카.프로그래밍3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[] solution(int n, int[] passenger, int[][] train) {
        int[] max = new int[2]; // [역 번호, 이용객 수]
        List<List<Integer>> lists = new ArrayList<>();
        int[] d = new int[n + 1];
        boolean[] isVisited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            lists.add(new ArrayList<>());
        }

        for (int[] info : train) {
            int station1 = info[0];
            int station2 = info[1];

            lists.get(station1).add(station2);
            lists.get(station2).add(station1);
        }

        Queue<Integer> qu = new LinkedList<>();
        qu.offer(1);
        d[1] = passenger[0];

        // 1번 역에서 각각 역까지의 이용객 수를 d 배열에 저장 (BFS)
        while (!qu.isEmpty()) {
            int curr = qu.poll();
            isVisited[curr] = true;

            for (int next : lists.get(curr)) {
                if (!isVisited[next]) {
                    qu.offer(next);
                    d[next] = d[curr] + passenger[next - 1];

                    if (d[next] >= max[1]) {
                        max[1] = d[next]; // 최대 이용객 수 최신화

                        if (d[next] == max[1] && next < max[0]) { // 이용객 수 같고, 역 번호 작으면 pass
                            continue;
                        }

                        max[0] = next; // 역 번호 최신화
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(6, new int[]{1, 1, 1, 1, 1, 1}, new int[][]{{1, 2}, {1, 3}, {1, 4}, {3, 5}, {3, 6}})));
        System.out.println(Arrays.toString(new Solution().solution(4, new int[]{2, 1, 2, 2}, new int[][]{{1, 2}, {1, 3}, {2, 4}})));
        System.out.println(Arrays.toString(new Solution().solution(5, new int[]{1, 1, 2, 3, 4}, new int[][]{{1, 2}, {1, 3}, {1, 4}, {1, 5}})));
    }
}