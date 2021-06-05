package _2021_라핀인.프로그래밍3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

class Solution {
    private Queue<AlgorithmComb> algorithmCombs;
    private Set<Integer> isSolved;
    private String[] algorithms;
    private List<Data> dataList;
    private int limitTime;
    private int limitSpace;
    private int totalTime;
    private int totalSpace;
    private int n;

    public String[] solution(int n, String[] data, String limit) {
        algorithms = new String[n];
        algorithmCombs = new PriorityQueue<>();
        isSolved = new HashSet<>();
        this.n = n;
        totalTime = 0;
        totalSpace = 0;

        // 제한 시간, 공간 설정
        String[] limits = limit.split(" ");
        limitTime = Integer.parseInt(limits[0]) == 0 ? Integer.MAX_VALUE : Integer.parseInt(limits[0]);
        limitSpace = Integer.parseInt(limits[1]) == 0 ? Integer.MAX_VALUE : Integer.parseInt(limits[1]);

        // Data 객체로 리스트에 추가
        dataList = new ArrayList<>();
        for (String d : data) {
            String[] dataInfo = d.split(" ");
            dataList.add(new Data(dataInfo[0], Integer.parseInt(dataInfo[1]), Integer.parseInt(dataInfo[2]), Integer.parseInt(dataInfo[3])));
        }

        // 가능한 알고리즘 조합
        combination(0, 0);

        if (algorithmCombs.isEmpty()) { // 가능한 알고리즘이 없으면
            return new String[]{};
        }

        return algorithmCombs.poll().algorithms; // 최적의 알고리즘 리턴
    }

    // 알고리즘 조합
    private void combination(int index, int depth) {
        if (depth == n) {
            String[] temp = algorithms.clone();
            algorithmCombs.add(new AlgorithmComb(temp, totalTime + totalSpace));
            return;
        }

        for (int i = index; i < dataList.size(); i++) {
            Data data = dataList.get(i);

            totalTime += data.time;
            totalSpace += data.space;

            if (totalTime <= limitTime && totalSpace <= limitSpace && !isSolved.contains(data.problemNum)) {
                algorithms[depth] = data.algorithm;
                isSolved.add(data.problemNum);
                combination(i + 1, depth + 1);
                isSolved.remove(data.problemNum);
            }
            totalTime -= data.time;
            totalSpace -= data.space;
        }
    }

    private static class Data {
        String algorithm;
        int problemNum;
        int time;
        int space;

        public Data(String algorithm, int problemNum, int time, int space) {
            this.algorithm = algorithm;
            this.problemNum = problemNum;
            this.time = time;
            this.space = space;
        }
    }

    // 알고리즘 조합과 (시간 + 공간)
    private static class AlgorithmComb implements Comparable<AlgorithmComb> {
        String[] algorithms;
        int cost;

        public AlgorithmComb(String[] algorithms, int cost) {
            this.algorithms = algorithms;
            this.cost = cost;
        }

        @Override
        public int compareTo(AlgorithmComb o) {
            if (cost == o.cost) { // 비용 같으면
                // 알고리즘
                for (int i = 0; i < algorithms.length; i++) {
                    if (algorithms[i].compareTo(o.algorithms[i]) == 0) {
                        continue;
                    }
                    return algorithms[i].compareTo(o.algorithms[i]);
                }
            }

            return cost - o.cost;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(2, new String[]{"a1 1 5 9", "a2 1 9 5", "b1 2 3 3"}, "0 10")));
        System.out.println(Arrays.toString(new Solution().solution(2, new String[]{"a1 1 6 6", "a2 1 2 9", "b1 2 3 3", "b2 2 4 1"}, "0 0")));
        System.out.println(Arrays.toString(new Solution().solution(1, new String[]{"a1 1 1 4", "a2 1 4 1", "a3 1 2 3", "a4 1 2 2"}, "3 5")));
    }
}
